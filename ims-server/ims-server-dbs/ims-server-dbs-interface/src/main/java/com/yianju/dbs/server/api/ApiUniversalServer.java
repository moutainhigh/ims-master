package com.yianju.dbs.server.api;

import com.alibaba.fastjson.JSONObject;
import com.yianju.dbs.server.entity.BaseResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 万能查询操作
 */
@RequestMapping("/universal")
public interface ApiUniversalServer {

    @RequestMapping("/query/{service}")
    public BaseResponse query(@PathVariable("service") String service , @RequestBody JSONObject param) throws Exception;


    /***
     * 扩展查询接口ß
     * @param service
     * @param param
     * @return
     */
    @RequestMapping("/queryExtend/{service}")
    public BaseResponse queryExtend(@PathVariable("service") String service , @RequestBody JSONObject param);
}
