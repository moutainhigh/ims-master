package com.yianju.ims.server.process.service.core;

import com.alibaba.fastjson.JSONObject;
import com.yianju.ims.entity.Result;
import com.yianju.ims.exception.CommonException;

/**
 * 处理单元
 */
public interface ProcessUnit {

    public Result process(JSONObject params) throws CommonException;

}
