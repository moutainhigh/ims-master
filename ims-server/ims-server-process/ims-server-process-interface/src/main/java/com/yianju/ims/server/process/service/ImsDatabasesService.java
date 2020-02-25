package com.yianju.ims.server.process.service;


import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("ims-server-dbs-service")
public interface ImsDatabasesService {

    @RequestMapping("/universal/query/{service}")
    public Result query(@PathVariable("service") String service, JSONObject param);
}
