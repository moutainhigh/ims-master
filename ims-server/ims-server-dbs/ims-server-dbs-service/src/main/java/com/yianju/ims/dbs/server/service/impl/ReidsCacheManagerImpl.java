package com.yianju.ims.dbs.server.service.impl;

import com.yianju.dbs.server.service.ReidsCacheManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@Slf4j
public class ReidsCacheManagerImpl implements ReidsCacheManager {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void test() {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set("MrDuan", "段宗文");
        String mrDuan = ops.get("MrDuan");
        log.info("获取信息为:{}",mrDuan);
    }
}
