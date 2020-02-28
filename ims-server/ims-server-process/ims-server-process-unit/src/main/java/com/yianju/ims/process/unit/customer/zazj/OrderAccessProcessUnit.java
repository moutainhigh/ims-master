package com.yianju.ims.process.unit.customer.zazj;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.exception.CommonException;
import com.yianju.ims.process.unit.customer.zazj.vo.EoCOrder;
import com.yianju.ims.process.unit.customer.zazj.vo.EoCOrderExtension;
import com.yianju.ims.process.unit.customer.zazj.vo.EoCOrderItem;
import com.yianju.ims.server.process.service.ImsDatabasesService;
import com.yianju.ims.server.process.service.core.AbstractProcessUnit;
import com.yianju.ims.util.HttpXmlClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 订单接入处理单元
 */
@Slf4j
public class OrderAccessProcessUnit extends AbstractProcessUnit{




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        super.applicationContext = applicationContext;
    }

    @Override
    public boolean preProcess(JSONObject json) throws CommonException {
        log.info("接入前校验");

        // 校验订单是否已经接入
        ImsDatabasesService imsDatabasesService = applicationContext.getBean(ImsDatabasesService.class);

        JSONObject object = new JSONObject();
        object.put("customerOrderNo",json.getString("orderNo"));
        object.put("customerCode","A0003340");
        Result queryDuplicateOrderCount = imsDatabasesService.query("queryDuplicateOrderCount", object);

        Map data = (Map)queryDuplicateOrderCount.getData();

        if(data!=null){
            Integer o = (Integer)data.get("COUNT(*)");
            if(o>0){
                throw new CommonException(ResultCode.ORDER_DUPLICATE);
            }
        }else{
            return super.preProcess(json);
        }

        // 校验订单接入是否合法
        return super.preProcess(json);
    }

    @Override
    public Result process(JSONObject params) throws CommonException {

        this.preProcess(params);


        log.info("start handle order access params is ：{}" , params.toString());
        EoCOrder eoCOrder = this.parseOrder(params);

        log.info("start send order to oms: ");
        String s = this.sendOrder(eoCOrder);

        log.info("完成处理");
        return new Result(ResultCode.SUCCESS,s);
    }



    @Override
    public void afterProcess() {
        super.afterProcess();
    }


    /**
     * 订单解析
     * @param params
     * @return
     */
    private EoCOrder parseOrder(JSONObject params) throws CommonException {

        ImsDatabasesService imsDatabasesService = this.applicationContext.getBean(ImsDatabasesService.class);

        EoCOrder order = new EoCOrder();

        JSONObject content = params.getJSONObject("content");

        JSONArray orderItemList = content.getJSONArray("order_item_list");

        // 客户订单号
        order.setEoorLogisticNo(content.getString("source_code"));
        // 订单类型，服务类型
        this.setOrderType(order,orderItemList);
        // 订单金额 total_amount
        order.setEoorAmount(content.getString("total_amount")==null?0.0:Double.parseDouble(content.getString("total_amount")));

        // 设置服务平台分公司
        this.setSiteCompany(order,content);

        // 设置客户信息
        this.setCustomer(order);

        // TODO 解析收货人省市区编码
        this.setReceiver(order,content,imsDatabasesService);

        this.setSender(order,content);

        // 设置业务方式等
        this.getBusinessType(order);


        // TODO 解释发货人省市区编码

        // 计划提货时间 delivery_plan_time

        // 预约送装时间 end_sign_time
        // 设置要求送达日期
        this.setEoorRequireConsigneeTime(order,content);

        // 订单来源 order_source_from

        // 备注（卖家备注） remark
        order.setEoorSellerRemark(content.getString("remark"));

        // 包裹重量 package_weight
        order.setEoorGrossWeight(content.getDouble("package_weight"));
        // 包裹体积 package_volume
        order.setEoorVolume(content.getDouble("package_volume"));

        // 包果数 package_number
        order.setEoorPackageQuantity(content.getDouble("package_number"));

        // lbx_code 物流单号/或商家来源单号2

        // 设置合作关系
        this.setCooperate(order,content);

        // order_item_list
        this.setOrderItems(order,orderItemList);
        return order;
    }

    /**
     * 设置合租关系
     * @param order
     * @param content
     */
    private void setCooperate(EoCOrder order, JSONObject content) {
        EoCOrderExtension extension = new EoCOrderExtension();
        extension.setEcoeEoorOrderNo(order.getEoorOrderNo());
        extension.setEcoeOwnnerCode("A0003340");
        extension.setEcoeOwnnerName("广州至爱智家科技有限公司");
        order.setEoCOrderExtensionBean(extension);
    }

    /**
     * 设置要求送达日期
     * @param order
     * @param object
     */
    private void setEoorRequireConsigneeTime(EoCOrder order, JSONObject object){
        try {
            String endSignTime = object.getString("end_sign_time");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(endSignTime==null){
                return;
            }
            order.setEoorRequireConsigneeTime(format.parse(endSignTime));
        } catch (ParseException e) {
            e.printStackTrace();
            log.error("解析要求送达日期失败，{}",e);
        }
    }

    /**
     * 订单的业务方式、出工类型、楼层是否需要如何设置
     * 业务方式默认为空；出工类型默认有电梯。
     * @param order
     */
    private void getBusinessType(EoCOrder order) {
        order.setEoorIsLift("3"); //有电梯
    }

    /**
     * 设置分公司、服务平台
     * 服务平台对接规则：根据城市划分，如果12个自有分部的订单，对应为的服务平台为总部服务平台（LMS0102），
     * 其他的对应到总部家装服务平台（LMS0259）。
     * 自有分部城市：北京、天津、哈尔滨、济南、太原、青岛、上海、南京、成都、广州、昆明、石家庄。
     * （使用收货人所在城市，市名称判断）
     */
    private void setSiteCompany(EoCOrder order,JSONObject content) {

        // 蚁安居（天津）网络技术有限公司
        order.setCompanyCode("30003357");
        order.setCompanyName("蚁安居（天津）网络技术有限公司");

        String brunchs = "北京、天津、哈尔滨、济南、太原、青岛、上海、南京、成都、广州、昆明、石家庄";
        String city = content.getString("receiver_city");
        city = city.replace("市","");

        if(brunchs.contains(city)){
            // 总部服务平台
            order.setSiteCode("LMS0102");
            order.setSiteName("总部服务平台");
            return;
        }
        // 总部服务家装
        order.setSiteCode("LMS0246");
        order.setSiteName("总部家装服务平台");
    }

    /**
     * 设置客户信息
     * @param order 订单
     */
    private void setCustomer(EoCOrder order) {
        // TODO 这个信息需要从登录用户
        order.setEoorCustomerCode("A0003340");
        order.setEoorCustomerName("广州至爱智家科技有限公司");
    }

    /**
     * 设置订单商品明细
     * @param order 订单
     * @param orderItemList 订单明细json报文
     */
    private void setOrderItems(EoCOrder order, JSONArray orderItemList) throws CommonException {

        // order_item_id: "438501",
        // item_name": "角阀三角阀/镀铬/单个",
        // item_code": "a",
        // item_class": "10000101",
        // item_quantity": "1",
        // item_price": "0",
        // item_weight": 0.314,
        // item_volume": 0.002392,
        // item_number": 1

        if(orderItemList==null || orderItemList.size()<1){
            throw new CommonException(ResultCode.ORDER_ITEM_LIST_NULL);
        }

        List<EoCOrderItem> items = new ArrayList<>();

        ImsDatabasesService imsDatabasesService = applicationContext.getBean(ImsDatabasesService.class);
        StringRedisTemplate template = applicationContext.getBean(StringRedisTemplate.class);

        for(int i=0;i<orderItemList.size();i++){
            EoCOrderItem item = new EoCOrderItem();
            JSONObject jsonObject = orderItemList.getJSONObject(i);
            String itemCode = jsonObject.getString("item_code");
            String cacheKey = "getMaterialByCustCode."+itemCode;
            Map<Object, Object> cacheMap = template.opsForHash().entries("getMaterialByCustCode." + itemCode);

            if(cacheMap==null){
                JSONObject obj = new JSONObject();
                obj.put("custMaterialNo",itemCode);
                Result query = imsDatabasesService.query("getMaterialByCustCode", obj);
                Object data = query.getData();
                Map<String, Object> map = (Map<String, Object>)data;
                if(map!=null){
                    String eooiCode = map.get("CDCM_MATERIAL_NO")==null? "" : (String)map.get("CDCM_MATERIAL_NO");
                    item.setEooiCode(eooiCode);
                    String eooiItemTypeCode = map.get("CDCM_TYPE_CODE")==null?"":(String)map.get("CDCM_TYPE_CODE");
                    item.setEooiItemTypeCode(eooiItemTypeCode);
                    String CDCM_PACKAGE_CODE = map.get("CDCM_PACKAGE_CODE")==null?"":(String)map.get("CDCM_PACKAGE_CODE");
                    item.setEooiPackageCode(CDCM_PACKAGE_CODE);
                }
                template.opsForHash().putAll(cacheKey,map);
                template.expire(cacheKey,2, TimeUnit.HOURS);
            }






            // TODO 通过商品客户编码获取倚天商品信息
            //item.setEooiCode("10000101");
            item.setEooiCustMaterialNo(jsonObject.getString("item_code"));
            item.setEooiName(jsonObject.getString("item_name"));

            item.setEooiOriginalQty(jsonObject.getDouble("item_quantity"));
            item.setEooiPrice(jsonObject.getDouble("item_price"));
            item.setEooiGrossWeight(jsonObject.getDouble("item_weight"));
            item.setEooiVolume(jsonObject.getDouble("item_volume"));
            item.setEooiLogisticNo(order.getEoorLogisticNo());
            item.setEooiIsCharge("1"); //默认计费件为是
            items.add(item);
        }

        order.setInOrderReceiveItemNewBean(items);

    }

    /**
     * 设置发货人信息
     * @param order 订单信息
     * @param content 报文信息
     */
    private void setSender(EoCOrder order, JSONObject content) {
        // 收货人省 sender_name
        order.setEoorShipperName(content.getString("sender_name"));
        // 收货人省 sender_province
        String provinceCode = this.getPlaceCode("PLACE_PROVINCE", "100000", content.getString("sender_province"));
        order.setEoorShipperProvinceCode(provinceCode);
        order.setEoorShipperProvinceName(content.getString("sender_province"));
        // 收货人市 sender_city
        String cityCode = this.getPlaceCode("PLACE_CITY", provinceCode, content.getString("sender_city"));
        order.setEoorShipperCityCode(cityCode);
        order.setEoorShipperCityName(content.getString("sender_city"));
        // 收货人区 sender_district
        String districtCode = this.getPlaceCode("PLACE_DISTRICT", cityCode, content.getString("sender_district"));
        order.setEoorShipperDistrictCode(districtCode);
        order.setEoorShipperDistrictName(content.getString("sender_district"));
        // 收货人地址 sender_address
        order.setEoorShipperLocationName(content.getString("sender_address"));
        // 收货人手机 sender_mobile
        order.setEoorShipperContactPhone(content.getString("sender_mobile"));
    }

    /**
     * 设置收货人信息
     * @param order 订单信息
     * @param content 报文内容
     */
    private void setReceiver(EoCOrder order, JSONObject content,ImsDatabasesService imsDatabasesService) {
        //收货人名称 receiver_name
        order.setEoorConsigneeName(content.getString("receiver_name"));
        // 收货人省 receiver_province
        // TODO
        String provinceCode = this.getPlaceCode("PLACE_PROVINCE", "100000", content.getString("receiver_province"));
        order.setEoorConsigneeProvinceCode(provinceCode);
        order.setEoorConsigneeProvinceName(content.getString("receiver_province"));
        // 收货人市 receiver_city

        String cityCode = this.getPlaceCode("PLACE_CITY", provinceCode, content.getString("receiver_city"));
        order.setEoorConsigneeCityCode(cityCode);
        order.setEoorConsigneeCityName(content.getString("receiver_city"));
        // 收货人区 receiver_district
        String districtCode = this.getPlaceCode("PLACE_DISTRICT", cityCode, content.getString("receiver_district"));
        order.setEoorConsigneeDistrictCode(districtCode);
        order.setEoorConsigneeDistrictName(content.getString("receiver_district"));
        // 收货人地址 receiver_address
        order.setEoorConsigneeLocationName(content.getString("receiver_address"));
        // 收货人手机 receiver_mobile
        order.setEoorConsigneeContactPhone(content.getString("receiver_mobile"));
    }


    /**
     * 获取省市区编码
     * @param level 级别
     * @param parantCode 上级编码
     * @param name 名称
     * @return
     */
    private String getPlaceCode(String level,String parantCode,String name){

        ImsDatabasesService imsDatabasesService = applicationContext.getBean(ImsDatabasesService.class);
        StringRedisTemplate template = applicationContext.getBean(StringRedisTemplate.class);


        try{

            if("PLACE_CITY".equals(level)){
                if("北京市".equals(name)){
                    name = "北京市辖区";
                }else if("天津市".equals(name)){
                    name = "天津市辖区";
                }else if("重庆市".equals(name)){
                    name = "重庆市辖区";
                }else if("上海市".equals(name)){
                    name = "上海市辖区";
                }
            }


            String key = "EB_PALCE." + level + "." + parantCode +"." + name;
            ValueOperations<String, String> ops = template.opsForValue();

            String s = ops.get(key);
            return s;


            /**
            JSONObject json = new JSONObject();
            json.put("type",level);
            json.put("code",parantCode);
            json.put("name",name);
            Result cityCodeQuery = imsDatabasesService.query("cityCodeQuery", json);
            log.info("获得解析数据为:{}",cityCodeQuery);
            Object data = cityCodeQuery.getData();
            Map<String,Object> map = (Map<String,Object>)data;
            String code = (String) map.get("EBPL_CODE");
            log.info("编码：{}",code);
             **/
            //return code;
        }catch (Exception e){
            e.printStackTrace();
            log.error("解析省市区编码出错");
        }

        return "";
    }


    /**
     * JavaBean转换成xml
     * @param obj bean信息
     * @param encoding 编码格式
     * @return
     */
    private String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送订单
     * @param order
     * @return
     */
    public String sendOrder(EoCOrder order){
        String url = "http://tscm.51eanj.com:88/module-oms2c/httpServices/MOMSHttpService";
        String xml = convertToXml(order, "UTF-8");
        String methodName = "newOrderAdd";
        Map<String, String> params = new HashMap<String, String>();
        params.put("methodName", methodName);
        params.put("data", xml);
        String post = HttpXmlClient.post(url, params);
        //return post;
        System.out.println(xml);
        return post;
    }


    /**
     * 设置订单类型
     * 五十家需求
     * 订单类型统一为出库订单；
     * 服务类型：与客户沟通确认，客户商品分为成品和定制家具，成品需要配送完安装，定制仅配送，
     * 接口对接时，根据订单商品明细中的item_class字段判断，如果是固定值99120107就是定制，
     * 对接的服务类型为运输+出库；如果不是规定值99120107，其他的都是成品，对接的服务类型为安装+运输+出库。
     * 客户反馈一个订单中，不会有成品和定制混合的情况、
     * （商品明细中如果包含99120107，则设置为运输+出库）
     * @param orderItemList 客户订单类型
     * @return
     */
    private void setOrderType(EoCOrder order,JSONArray orderItemList) {
        /*
         * 三包：10
         * 干线：20
         * 配送：30
         * 安装：31
         * 维修：32
         * 退货：33
         * 展摆：34
         * 撤展：35
         * 检测：36
         * 治理：37
         * 保养：38
         * 支装：40
         * 干支到家：70
         * 调拨单：80
         * 快递单：90
         * 报废 ：39
         */
        String orderTypeCode = "PO";

        // 服务类型03 安装+运输+出库 /  01 运输+出库
        String eoorDelierySetupType = "03";

        try{
            for(int i=0;i<orderItemList.size();i++){
                JSONObject jsonObject = orderItemList.getJSONObject(i);
                String itemClass = jsonObject.getString("item_class");
                if("99120107".equals(itemClass)){
                    eoorDelierySetupType = "01";
                    break;
                }
            }
        }catch (Exception e){
            log.error("设置服务类型错误：{}",e);
        }

        order.setEoorOrderTypeCode(orderTypeCode);
        order.setEoorDelierySetupType(eoorDelierySetupType);
        order.setEoorStatusCode("00"); //订单状态新增
        order.setEoorStatusName("新增");
        // order.setEoorExceptionStatus("00"); //作业状态信息
        order.setEoorExecuteStatus("00"); //作业状态信息
    }


}
