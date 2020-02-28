package com.yianju.ims.server.process.service;


import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import com.yianju.ims.security.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="ims-server-dbs-service",configuration={FeignConfig.class})
public interface ImsDatabasesService {

    @PostMapping("/universal/query/{service}")
    public Result query(@PathVariable("service") String service, JSONObject param);
}
