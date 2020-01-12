package com.yianju.ims.dbs.server;

import com.yianju.dbs.server.entity.DbConnection;
import com.yianju.dbs.server.entity.InterfaceConfig;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class BbHelper {


    public Map<String,Object> query(String type,String url,String user,String password){

        DriverManagerDataSource dataSource = getDataSource(type, url, user, password);

        // 2.获得查询模板
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);

        // 3.执行查询
        //List list = template.queryForList(sql, params);

        return null;
    }

    /**
     * 获取数据源连接
     * @return
     */
    private DriverManagerDataSource getDataSource(String type,String url,String user,String password) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        switch (type){
            case "ORACLE":
                dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            case "MYSQL":
                dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        }

        dataSource.setUsername(url);
        dataSource.setPassword(user);
        dataSource.setUrl(password);
        return dataSource;
    }




}
