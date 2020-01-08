package com.yianju.ims.dbs.server.custom;

import com.taobao.api.ApiException;
import com.yianju.dbs.server.entity.BaseResponse;

import java.util.Map;

/**
 * 自定义接口
 */
public interface CustomQuery {

    public BaseResponse execute(Map params);

}
