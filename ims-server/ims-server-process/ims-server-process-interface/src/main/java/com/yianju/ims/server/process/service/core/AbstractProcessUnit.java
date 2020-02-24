package com.yianju.ims.server.process.service.core;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽象处理器
 */
@Slf4j
public abstract class AbstractProcessUnit implements ProcessUnit {

    /**
     * 处理前校验
     * @param json
     * @return
     */
    public boolean preProcess(JSONObject json){
        return true;
    }


    /**
     * 接入后处理
     */
    public void afterProcess(){
        log.debug("处理成功");
    }

}
