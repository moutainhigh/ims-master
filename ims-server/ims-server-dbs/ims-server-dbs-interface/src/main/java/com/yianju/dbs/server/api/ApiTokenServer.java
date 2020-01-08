package com.yianju.dbs.server.api;

import com.alibaba.fastjson.JSONObject;
import com.yianju.dbs.server.entity.ApiToken;
import com.yianju.dbs.server.entity.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * token 服务
 */
public interface ApiTokenServer {

    /**
     * 获取token
     * @param params
     * @return
     */
    @RequestMapping("/token")
    public BaseResponse token(@RequestBody JSONObject params);

    /**
     * 保存ApiToken信息
     * @param apiToken
     * @return
     */
    @RequestMapping("/saveApiToken")
    public BaseResponse saveApiToken(ApiToken apiToken);


    /**
     * 更新ApiToken信息
     * @param apiToken
     * @return
     */
    @RequestMapping("/updateApiToken")
    public BaseResponse updateApiToken(ApiToken apiToken);


    /**
     * 重置token信息
     * @param apiToken
     * @return
     */
    @RequestMapping("/resetApiToken")
    public BaseResponse resetApiToken(ApiToken apiToken);

}
