package com.yianju.ims.dbs.server.service.impl;

import com.yianju.dbs.server.api.ApiDataBasesServer;
import com.yianju.dbs.server.entity.DbConnection;
import com.yianju.ims.dbs.server.constant.DBSConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@RestController
public class ApiDataBasesServerImpl extends BaseServiceImpl<DbConnection> implements ApiDataBasesServer {



    @Override
    public int saveConnection(DbConnection connection) {
        return this.save(connection);
    }

    @Override
    public boolean testConnection(DbConnection connection) {

        String dbtype = connection.getDbtype();

        switch (dbtype){
            case "ORACLE":
                return getConnection(connection.getUrl(),connection.getUser(),connection.getPassword(),DBSConstant.ORACLE_DRIVER_CLASS);
            case "MYSQL":
                return getConnection(connection.getUrl(),connection.getUser(),connection.getPassword(),DBSConstant.MYSQL_DRIVER_CLASS);
            default:
                return false;
        }
    }

    /**
     * 连接Oracle数据库
     * @param url 数据库连接地址
     * @param user 用户名
     * @param password 账号
     * @param driverClass 驱动
     * @return
     */
    private boolean getConnection(String url,String user,String password,String driverClass) {
        Connection connection = null;
        try{
            if(StringUtils.isEmpty(url) || StringUtils.isEmpty(user) || StringUtils.isEmpty(password)){
                return false;
            }
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
            return true;
        }catch (Exception e){
            return false;
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("获取数据库连接信息异常，异常信息为：{}",e.getMessage());
                }
            }
        }
    }

}
