package com.yianju.ims.dbs.server.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.yianju.dbs.server.api.ApiUniversalManager;
import com.yianju.dbs.server.entity.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;

/**
 * 缓存数据初始化
 */
@WebListener
@Component
@Slf4j
public class CacheInitDataListener implements ServletContextListener {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private ApiUniversalManager apiUniversalManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            BaseResponse getAllPalce = apiUniversalManager.query("getAllPalce", new JSONObject());
            Object data = getAllPalce.getData();
            List<Map<String, Object>> list =(List<Map<String, Object>>)data;
            Gson gson = new Gson();
            ValueOperations<String, String> ops = template.opsForValue();
            for (Map<String, Object> map: list) {
                String EBPL_CODE = (String)map.get("EBPL_CODE");
                String EBPL_NAME_CN = (String)map.get("EBPL_NAME_CN");
                String EBPL_TYPE = (String)map.get("EBPL_TYPE");
                String EBPL_PARENT_PM_CODE = (String)map.get("EBPL_PARENT_PM_CODE");
                ops.set("EB_PALCE." + EBPL_TYPE + "." + EBPL_PARENT_PM_CODE +"." + EBPL_NAME_CN,EBPL_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("初始化缓存异常:{}",e);
        }

    }
}
