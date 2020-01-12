package com.yianju.ims.dbs.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.yianju.dbs.server.api.ApiUniversalServer;
import com.yianju.dbs.server.entity.BaseResponse;
import com.yianju.dbs.server.entity.DbConnection;
import com.yianju.dbs.server.entity.InterfaceConfig;
import com.yianju.ims.dbs.server.custom.CustomQuery;
import com.yianju.ims.dbs.server.custom.impl.DingtalkCustomQuery;
import com.yianju.ims.dbs.server.custom.impl.WinXinCustomQuery;
import com.yianju.ims.dbs.server.mapper.DbConnectionMapper;
import com.yianju.ims.dbs.server.mapper.InterfaceConfigMapper;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.exception.CommonException;
import com.yianju.ims.service.impl.BaseManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@RestController
public class ApiUniversalMangerImpl extends BaseManagerImpl<InterfaceConfig> implements ApiUniversalServer {

    private static Pattern conditionPattern = Pattern.compile("<<(?:(?!<<).)+?>>", Pattern.DOTALL);

    private static Pattern paramPattern = Pattern.compile(":\\w*(?=>>|||)");

    @Autowired
    private InterfaceConfigMapper interfaceConfigMapper;

    @Autowired
    private DbConnectionMapper dbConnectionMapper;

    @Override
    public BaseResponse query(String service, JSONObject params) throws Exception {

        try{
            // 1.通过service获取到数据库连接信息
            InterfaceConfig ic = this.getInterfaceConfig(service);

            // 2.通过数据库连接执行查询SQL
            String sql = ic.getSqlText();
            log.info("请求sql为：{}",sql);

            // 3.获取sql中的参数
            List<String> runSqlParam = this.getRunSqlParam(sql);

            // 4.校验合法性
            Map validate = this.validate(sql, params);
            boolean success = (boolean) validate.get("success");
            if(!success){
                //throw  new CommonException(false,10005,"请求失败，必须项："+ validate.get("errorMsg") +"为填写，请检查输入");
                //throw  new CommonException(ResultCode.REQUIRED_FEILD);
                return new BaseResponse(-1,"请求失败，必须项："+ validate.get("errorMsg") +"为填写，请检查输入",null);
            }

            // 5.获得执行sql
            String runSql = this.getRunSql(sql, params).replace("/",":");

            Object data = getQueryData(ic, runSql, params);

            return new BaseResponse(0,"请求成功",data);
        }catch (Exception exception){
            return new BaseResponse(-1, exception.getMessage(),null);
        }

    }



    /**
     * 查询数据
     * @param interfaceConfig
     * @param sql
     * @param params
     * @return
     */
    private Object getQueryData(InterfaceConfig interfaceConfig,String sql,Map params){
        // 1.获得数据源
        DriverManagerDataSource dataSource = this.getDataSource(interfaceConfig);

        // 2.获得查询模板
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);

        // 3.执行查询
        List list = template.queryForList(sql, params);

        int isRetOne = interfaceConfig.getIsRetOne();

        if(isRetOne == 1){
            if(list!=null && list.size()>0){
                return list.get(0);
            }
        }

        return list;
    }


    /**
     *
     * @param service
     */
    public InterfaceConfig getInterfaceConfig(String service) throws CommonException {
        QueryWrapper<InterfaceConfig> wrapper = new QueryWrapper<>();
        wrapper.eq("service_code",service).eq("rec_status",0L);
        List<InterfaceConfig> interfaceConfigs = interfaceConfigMapper.selectList(wrapper);
        if(interfaceConfigs!=null && interfaceConfigs.size()==1){
            InterfaceConfig interfaceConfig = interfaceConfigs.get(0);
            return interfaceConfigs.get(0);
        }
        throw new CommonException(ResultCode.NOT_FOUND);
    }


    private Map validate(String sql, Map<String,Object> param){

        Map map = new HashMap();
        boolean validate = true;

        // 1.1编译成可执行SQL
        String runSql = getRunSql(sql, param);

        // 1.2获取全部参数
        List<String> runSqlParam = getRunSqlParam(runSql);

        // 1.3查看参数是否存在
        for(String s: runSqlParam){
            Object o = param.get(s);
            log.info("获得参数为：{}，获得值为:{}",s,o);
            if(o == null || "".equals(o)){
                validate = false;
                String errorMsg = map.get("errorMsg") == null ? s : map.get("errorMsg") + "," + s;
                map.put("errorMsg",errorMsg);
            }
        }

        map.put("success",validate);
        return map;
    }

    private List<String> getRunSqlParam(String sql) {
        List list = new ArrayList();
        Pattern pattern = Pattern.compile("\\:(\\w+)");
        Matcher matcher = pattern.matcher(sql);
        while(matcher.find()){
            list.add(matcher.group(0).replace(":",""));
        }
        return list;
    }


    /**
     * 解析<<>>表达式
     * @param sql
     * @param params
     * @return
     */
    private String getRunSql(String sql, Map params){
        StringBuffer sqlBuf = new StringBuffer();
        Matcher conditionMatcher = conditionPattern.matcher(sql);
        while (conditionMatcher.find()) {
            String condition = conditionMatcher.group();

            Matcher paraMatch = paramPattern.matcher(condition);
            boolean validate = true;
            while (paraMatch.find()) {
                String paraName = paraMatch.group(0);// 获取第0个数据 update by Blake 2015-11-17 18:00:15
                if (paraName == null) {
                    paraName = paraMatch.group(5);
                }else{
                    paraName = paraName.replace(":", "").trim();
                }

                if (params.get(paraName) == null || "".equals(params.get(paraName))) {
                    validate = false;
                    break;
                }
            }
            conditionMatcher.appendReplacement(sqlBuf, "");
            if (validate) {
                sqlBuf.append(condition.replaceAll("(<<)|(>>)", ""));
            }
        }
        conditionMatcher.appendTail(sqlBuf);
        return sqlBuf.toString().replaceAll("([ \t]*\n\t*)+", "\n");
    }

    /**
     * 获取数据源连接
     * @return
     */
    private DriverManagerDataSource getDataSource(InterfaceConfig ic) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        Long dbConId = ic.getDbConId();

        DbConnection dbConnection = dbConnectionMapper.selectById(dbConId);

        if(dbConnection == null){
            return null;
        }

        String dbtype = dbConnection.getDbtype();

        switch (dbtype){
            case "ORACLE":
                dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            case "MYSQL":
                dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        }


        dataSource.setUsername(dbConnection.getUser());
        dataSource.setPassword(dbConnection.getPassword());
        dataSource.setUrl(dbConnection.getUrl());
        return dataSource;
    }

    @Override
    public BaseResponse queryExtend(String service, JSONObject param) {

        // TODO 第一步通过service获取配置
        // 要要使用钉钉接口还是微信接口

        // TODO 根据配置确认自定义实现
        CustomQuery query = null;
        if("weixin".equals(service)){
            query = new WinXinCustomQuery();
        }else if("dingtalk".equals(service)){
            query = new DingtalkCustomQuery();
        }
        return query.execute(param);
    }
}
