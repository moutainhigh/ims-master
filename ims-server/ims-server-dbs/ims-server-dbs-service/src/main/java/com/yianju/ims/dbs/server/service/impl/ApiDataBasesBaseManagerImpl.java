package com.yianju.ims.dbs.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yianju.dbs.server.api.ApiDataBasesServer;
import com.yianju.dbs.server.entity.DbConnection;
import com.yianju.ims.constant.ImsConst;
import com.yianju.ims.dbs.server.constant.DBSConstant;
import com.yianju.ims.entity.PageResult;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.service.impl.BaseManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@RestController
public class ApiDataBasesBaseManagerImpl extends BaseManagerImpl<DbConnection> implements ApiDataBasesServer {

    @Override
    public Result saveConnection(DbConnection connection) {
        String dbtype = connection.getDbtype();

        switch (dbtype){
            case "MYSQL":
                connection.setColor("green");
                break;
            case "ORACLE":
                connection.setColor("magenta");
                break;
                default:
                    connection.setColor("#1890ff");
        }

        Long id = connection.getId();
        if(id == null || id == 0L){
            this.save(connection);
        }

        this.update(connection);

        return new Result(ResultCode.SUCCESS);

    }

    @Override
    public Result testConnection(DbConnection connection) {

        String dbtype = connection.getDbtype();
        switch (dbtype){
            case "ORACLE":
                return getConnection(connection.getUrl(), connection.getUser(), connection.getPassword(), DBSConstant.ORACLE_DRIVER_CLASS);
            case "MYSQL":
                return getConnection(connection.getUrl(),connection.getUser(),connection.getPassword(),DBSConstant.MYSQL_DRIVER_CLASS);
            default:
                return new Result(ResultCode.FAIL);
        }
    }

    @Override
    public PageResult databasesList(JSONObject json) {

        System.out.println(json);
        String search = json.getString("search");
        Integer current = json.getInteger("current")==null?1:json.getInteger("current");
        Integer pageSize = json.getInteger("pageSize")==null?10:json.getInteger("pageSize");

        String dbtype = json.getString("dbtype");

        QueryWrapper<DbConnection> queryWrapper = new  QueryWrapper();
        queryWrapper.eq("rec_status",ImsConst.REC_OK);
        if(search!=null && !"".equals(search)){
            queryWrapper.eq("name",search);
        }
        if(dbtype!=null && !"".equals(dbtype)){
            queryWrapper.eq("dbtype",dbtype);
        }
        IPage<DbConnection> dbConnectionIPage = this.queryPageList(queryWrapper, current, pageSize);


        PageResult result = new PageResult();
        result.setData(dbConnectionIPage.getRecords());
        result.setCurrent(dbConnectionIPage.getCurrent());
        result.setPageSize(dbConnectionIPage.getSize());
        result.setTotal(dbConnectionIPage.getTotal());
        result.setCode(10000);
        result.setSuccess(true);
        result.setMessage("请求成功");
        return result;
    }

    @Override
    public Result removeConnection(DbConnection connection) {
        DbConnection dbConnection = this.queryById(connection.getId());
        dbConnection.setRecStatus(ImsConst.REC_DELETE);
        Integer update = this.update(dbConnection);
        if(update>0){
           return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    /**
     * 连接Oracle数据库
     * @param url 数据库连接地址
     * @param user 用户名
     * @param password 账号
     * @param driverClass 驱动
     * @return
     */
    private Result getConnection(String url,String user,String password,String driverClass) {
        Connection connection = null;
        try{
            if(StringUtils.isEmpty(url) || StringUtils.isEmpty(user) || StringUtils.isEmpty(password)){
                return new Result(ResultCode.FAIL,"请检查用户或密码！");
            }
            Class.forName(driverClass);
            DriverManager.setLoginTimeout(3); //设置登录超时时常
            connection = DriverManager.getConnection(url, user, password);
            return new Result(ResultCode.SUCCESS,"连接成功");
        }catch (Exception e){
            return new Result(ResultCode.FAIL,e.getMessage());
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("获取数据库连接信息异常，异常信息为：{}",e.getMessage());
                    return new Result(ResultCode.FAIL,e.getMessage());
                }
            }
        }
    }

}
