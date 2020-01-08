package com.wsj.test;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RunSqlTest {

    private static Pattern conditionPattern = Pattern.compile("<<(?:(?!<<).)+?>>", Pattern.DOTALL);

    private static Pattern paramPattern = Pattern.compile(":\\w*(?=>>|||)");

    @Test
    public void testRunSql(){
        String sql = "select id,name,`password`,DATE_FORMAT(create_time,'yyyy-mm-dd hh24/mi/ss') create_time,DATE_FORMAT(update_time,'%Y-%m-%d %H:%i:%s') update_time from user2 " +
                "where 1=1 " +
                "<< and name=:name >> " +
                "<< and id=:id >>";


        Map params = new HashMap();
        params.put("name","mrduan");
        // 1.校验参数，编译sql获得全部参数
        Map validate = validate(sql, params);

        boolean success = (boolean) validate.get("success");

        if(!success){
            log.info("请求失败，必须项：{}为填写，请检查输入",validate.get("errorMsg"));
        }

        // 2.检验所有必填参数是否都有值，空值不可以
        String runSql = this.getRunSql(sql, params).replace("/",":");

        DriverManagerDataSource dataSource = this.getDataSource();

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);

        List list = template.queryForList(runSql, params);

        Gson gson = new Gson();
        String s = gson.toJson(list);

        System.out.println(runSql);
        System.out.println(s);

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
                System.out.println(paraName);
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
    private DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //TODO 写死
        Integer rpcnDbtype = 2;

        // oracle数据源
        if(rpcnDbtype == 1){
            dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        }

        // mysql数据源
        if(rpcnDbtype == 2){
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        }

        dataSource.setUsername("root");
        dataSource.setPassword("ab123");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }
}
