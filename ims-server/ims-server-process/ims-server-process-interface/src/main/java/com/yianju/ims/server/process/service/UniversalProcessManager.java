package com.yianju.ims.server.process.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 万能处理器
 */
public interface UniversalProcessManager {

    /**
     * 处理程序入口
     * @param processCode
     * @param param
     * @return
     */
    @RequestMapping("/process/{processCode}")
    public Result process(@PathVariable String processCode , @RequestBody JSONObject param);

}
