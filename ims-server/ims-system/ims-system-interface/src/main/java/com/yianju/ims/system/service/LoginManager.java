package com.yianju.ims.system.service;

import com.yianju.ims.entity.Result;
import com.yianju.ims.system.entity.LoginRequestEntity;
import com.yianju.ims.system.entity.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录接口
 */
public interface LoginManager{

    /**
     * 用户登录
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public Result login(@RequestBody LoginRequestEntity request);

    /**
     * 获取当前登录用户
     * @return
     */
    @RequestMapping("/currentUser")
    public UserDetails currentUser(HttpServletRequest request);

}

