package com.yianju.ims.process.unit.customer.zazj;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.exception.CommonException;
import com.yianju.ims.process.unit.customer.zazj.vo.EoCOrder;
import com.yianju.ims.process.unit.customer.zazj.vo.EoCOrderItem;
import com.yianju.ims.server.process.service.core.AbstractProcessUnit;
import com.yianju.ims.util.HttpXmlClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单接入处理单元
 */
@Slf4j
public class OrderAccessProcessUnit extends AbstractProcessUnit {


    @Override
    public boolean preProcess(JSONObject json) {

        // 校验订单接入是否合法

        return super.preProcess(json);
    }

    @Override
    public Result process(JSONObject params) throws CommonException {

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

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        log.info(authorization);

        EoCOrder order = new EoCOrder();

        JSONObject content = params.getJSONObject("content");

        // 客户订单号
        order.setEoorLogisticNo(content.getString("source_code"));
        // 订单类型，服务类型
        this.setOrderType(order,content.getString("order_type"));
        // 订单金额 total_amount
        order.setEoorAmount(content.getString("total_amount")==null?0.0:Double.parseDouble(content.getString("total_amount")));

        // TODO 解析收货人省市区编码
        this.setReceiver(order,content);




        this.setSender(order,content);


        // TODO 解释发货人省市区编码

        // 计划提货时间 delivery_plan_time

        // 预约送装时间 end_sign_time


        // 订单来源 order_source_from

        // 备注（卖家备注） remark

        // 包裹重量 package_weight

        // 包裹体积 package_volume

        // 包果数 package_number

        // lbx_code 物流单号/或商家来源单号2

        // order_item_list

        JSONArray orderItemList = content.getJSONArray("order_item_list");
        this.setOrderItems(order,orderItemList);






        return order;
    }

    /**
     * 设置订单商品明细
     * @param order
     * @param orderItemList
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

        List<EoCOrderItem> items = new ArrayList<EoCOrderItem>();

        for(int i=0;i<orderItemList.size();i++){
            EoCOrderItem item = new EoCOrderItem();
            JSONObject jsonObject = orderItemList.getJSONObject(i);
            jsonObject.getString("item_name");

            // TODO 通过商品客户编码获取倚天商品信息
            //item.setEooiCode("10000101");
            item.setEooiCustMaterialNo("10000101");
            item.setEooiName("角阀三角阀/镀铬/单个");

            item.setEooiQuantity(jsonObject.getDouble("item_quantity"));
            item.setEooiPrice(jsonObject.getDouble("item_price"));
            item.setEooiGrossWeight(jsonObject.getDouble("item_weight"));
            item.setEooiVolume(jsonObject.getDouble("item_volume"));
            item.setEooiLogisticNo(order.getEoorLogisticNo());
            items.add(item);
        }

        order.setInOrderReceiveItemNewBean(items);

    }

    /**
     * 设置发货人信息
     * @param order
     * @param content
     */
    private void setSender(EoCOrder order, JSONObject content) {
        // 收货人省 sender_name
        order.setEoorShipperName(content.getString("sender_name"));
        // 收货人省 sender_province
        order.setEoorShipperProvinceCode("");
        order.setEoorShipperProvinceName(content.getString("sender_province"));
        // 收货人市 sender_city
        order.setEoorShipperCityCode("");
        order.setEoorShipperCityName(content.getString("sender_city"));
        // 收货人区 sender_district
        order.setEoorShipperDistrictCode("");
        order.setEoorShipperDistrictName(content.getString("sender_district"));
        // 收货人地址 sender_address
        order.setEoorShipperLocationName(content.getString("sender_address"));
        // 收货人手机 sender_mobile
        order.setEoorConsigneeContactTel(content.getString("sender_mobile"));
    }

    /**
     * 设置收货人信息
     * @param order
     * @param content
     */
    private void setReceiver(EoCOrder order, JSONObject content) {
        //收货人名称 receiver_name
        order.setEoorConsigneeName(content.getString("receiver_name"));
        // 收货人省 receiver_province
        // TODO
        order.setEoorConsigneeProvinceCode("");
        order.setEoorConsigneeProvinceName(content.getString("receiver_province"));
        // 收货人市 receiver_city
        order.setEoorConsigneeCityCode("");
        order.setEoorConsigneeCityName(content.getString("receiver_city"));
        // 收货人区 receiver_district
        order.setEoorConsigneeDistrictCode("");
        order.setEoorConsigneeDistrictName(content.getString("receiver_district"));
        // 收货人地址 receiver_address
        order.setEoorConsigneeLocationName(content.getString("receiver_address"));
        // 收货人手机 receiver_mobile
        order.setEoorConsigneeContactTel(content.getString("receiver_mobile"));
    }


    /**
     * JavaBean转换成xml
     * @param obj
     * @param encoding
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
     * @param order_type
     * @return
     */
    private void setOrderType(EoCOrder order,String order_type) {
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
        String orderTypeCode = null;

        // TODO

        switch (order_type){
            case "10":
                orderTypeCode = "00";
                break;
            default:
                orderTypeCode = "PO";
                break;
        }

        order.setEoorOrderTypeCode(orderTypeCode);
        order.setEoorDelierySetupType("00");
    }

}
