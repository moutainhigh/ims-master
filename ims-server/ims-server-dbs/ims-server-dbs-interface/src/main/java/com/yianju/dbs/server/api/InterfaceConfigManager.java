package com.yianju.dbs.server.api;

import com.alibaba.fastjson.JSONObject;
import com.yianju.dbs.server.entity.InterfaceConfig;
import com.yianju.ims.entity.PageResult;
import com.yianju.ims.entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 接口信息配置
 */
@RequestMapping("/interfaceConfig")
public interface InterfaceConfigManager {

    /**
     * 保存查询配置信息
     * @param ic
     * @return
     */
    @RequestMapping("/save")
    public Result saveInterfaceConfig(@RequestBody InterfaceConfig ic);


    /**
     * 接口配置列表
     * @param params 参数
     * @return
     */
    @RequestMapping("/interfaceConfigList")
    public PageResult interfaceConfigList(@RequestBody JSONObject params);
}
