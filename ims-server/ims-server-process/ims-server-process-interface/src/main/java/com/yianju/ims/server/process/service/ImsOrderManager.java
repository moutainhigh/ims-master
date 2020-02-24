package com.yianju.ims.server.process.service;

import com.yianju.ims.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单管理器
 */
public interface ImsOrderManager {


    @RequestMapping
    public Result access();

}
