package com.yianju.dbs.server.api;

import com.alibaba.fastjson.JSONObject;
import com.yianju.dbs.server.entity.DbConnection;
import com.yianju.ims.entity.PageResult;
import com.yianju.ims.entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据库服务接口
 */
@RequestMapping("/apidb")
public interface ApiDataBasesManager {

    /**
     * 保存连接
     *
     * @param connection
     * @return
     */
    @RequestMapping("/saveConnection")
    public Result saveConnection(@RequestBody DbConnection connection);

    /**
     * 测试测试连接是否生效
     *
     * @param connection
     * @return
     */
    @RequestMapping("/testConnection")
    public Result testConnection(@RequestBody DbConnection connection);


    @RequestMapping("/databasesList")
    public PageResult databasesList(@RequestBody JSONObject json);

    /**
     * 删除连接
     * @param connection
     * @return
     */
    @RequestMapping("/removeConnection")
    public Result removeConnection(@RequestBody DbConnection connection);
}
