package com.yianju.ims.system.service;

import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import com.yianju.ims.system.model.ApiToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * token 服务
 */
public interface ApiTokenManager {

    /**
     * 获取token
     * @param params
     * @return
     */
    @RequestMapping("/token")
    public Result token(@RequestBody JSONObject params);

    /**
     * 保存ApiToken信息
     * @param apiToken
     * @return
     */
    @RequestMapping("/saveApiToken")
    public Result saveApiToken(@RequestBody ApiToken apiToken);


    /**
     * 更新ApiToken信息
     * @param apiToken
     * @return
     */
    @RequestMapping("/updateApiToken")
    public Result updateApiToken(@RequestBody ApiToken apiToken);


    /**
     * 重置token信息
     * @param apiToken
     * @return
     */
    @RequestMapping("/resetApiToken")
    public Result resetApiToken(@RequestBody ApiToken apiToken);

}
