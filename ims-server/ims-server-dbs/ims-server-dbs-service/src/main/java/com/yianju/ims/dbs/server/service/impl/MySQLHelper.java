package com.yianju.ims.dbs.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MySQLHelper{


    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;



    private static final String DIRVER_CLASS = "com.mysql.jdbc.Driver";

    public MySQLHelper(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection(){
        return null;
    }

    public int insert(String sql, Object... condition) {
        return update(sql,condition);
    }

    public int update(String sql, Object... condition) {
        log.debug("请求sql为：{}",sql);
        log.debug("请求参数为：{}",condition);

        try {
            long start = System.currentTimeMillis();
            statement = connection.prepareStatement(sql);
            setConditions(statement,condition);
            int result = statement.executeUpdate();
            long end =  System.currentTimeMillis();
            log.debug("请求耗时：{}ms",end-start);
            log.debug("执行影响行数为：{}",result);
            return result;
        } catch (SQLException e) {
            log.error("处理异常：异常原因为：{}",e);
            return 0;
        } finally {
            closeAll(connection,statement,resultSet);
        }

    }

    public int delete(String sql, Object... condition) {
        return update(sql,condition);
    }

    public <T> List<T> query(String sql, Class<T> clazz, Object... condition) {

        log.debug("请求sql为：{}",sql);
        log.debug("请求参数为：{}",condition);
        try {
            long start = System.currentTimeMillis();
            statement = connection.prepareStatement(sql);
            setConditions(statement,condition);
            ResultSet resultSet = statement.executeQuery(sql);

            return convertBean(resultSet,clazz);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,statement,resultSet);
        }

        // 1。获得查询结果集

        // 2。转换为
        return null;
    }

    private <T> List<T> convertBean(ResultSet resultSet, Class<T> clazz) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            List list = new ArrayList();
            T t = clazz.newInstance();

            if(t instanceof Map ){
                while(resultSet.next()){
                    Map map = (Map)clazz.newInstance();
                    for (int i=1;i<=columnCount;i++){
                        String filed = metaData.getColumnName(i);
                        Object object = resultSet.getObject(i);
                        log.info("字段名称为：{},字段值为：{}",filed,object);
                        log.info("字段名称为："+ filed +",字段值为：" +object);

                        map.put(filed,object);
                    }
                    list.add(map);
                }

                return list;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 设置条件
     * @param pst
     * @param params
     */
    private void setConditions(PreparedStatement pst, Object... params) {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                try {
                    pst.setObject(i + 1, params[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 关闭资源
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeAll(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MySQLHelper dbHelper = new MySQLHelper("jdbc:mysql://localhost:3306/test","root","ab123");
        //int mrduan = dbHelper.insert("insert into user2 (name,password) values (?,?) ","mrduan3","123456");
        //int mrduan = dbHelper.insert("insert into `user` (`name`,`password`) values (?,?)","root","123456");
        //System.out.print(mrduan);
        //List<User> query = dbHelper.query("select * from user2 ", User.class);
    }

}
