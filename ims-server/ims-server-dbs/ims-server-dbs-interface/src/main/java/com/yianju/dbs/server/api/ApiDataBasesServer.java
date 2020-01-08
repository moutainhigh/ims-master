package com.yianju.dbs.server.api;

import com.yianju.dbs.server.entity.DbConnection;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据库服务接口
 */
@RequestMapping("/apidb")
public interface ApiDataBasesServer {

    /**
     * 保存连接
     * @param connection
     * @return
     */
    @RequestMapping("/saveConnection")
    public int saveConnection(DbConnection connection);

    /**
     * 测试测试连接是否生效
     * @param connection
     * @return
     */
    @RequestMapping("/testConnection")
    public boolean testConnection(DbConnection connection);

}
