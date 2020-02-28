package com.yianju.dbs.server.service;


import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Reids缓存处理器
 */
public interface ReidsCacheManager {

    @RequestMapping("/test")
    public void test();

}
