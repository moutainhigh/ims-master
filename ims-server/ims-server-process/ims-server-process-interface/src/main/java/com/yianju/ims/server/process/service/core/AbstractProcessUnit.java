package com.yianju.ims.server.process.service.core;

import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 抽象处理器
 */
@Slf4j
public abstract class AbstractProcessUnit  implements ProcessUnit , ApplicationContextAware {


    protected ApplicationContext applicationContext;

    /**
     * 处理前校验
     * @param json
     * @return
     */
    public boolean preProcess(JSONObject json) throws CommonException {
        return true;
    }


    /**
     * 接入后处理
     */
    public void afterProcess(){
        log.debug("处理成功");
    }

}
