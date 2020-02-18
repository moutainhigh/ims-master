package com.yianju.ims.interceptor;

import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.exception.CommonException;
import com.yianju.ims.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 */
@Component
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private JwtUtil jwtUtils;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(request.getRequestURI());
        // 1.通过request获取请求token信息
        String authorization = request.getHeader("Authorization");
        //判断请求头信息是否为空，或者是否已Bearer开头
        if(!StringUtils.isEmpty(authorization)) {
            //获取token数据
            String token = authorization.replace("YIANJU ","");
            //解析token获取claims
            Claims claims = jwtUtils.parseJwt(token);
            if(claims != null) {
                request.setAttribute("user_claims",claims);
                return true;
                // TODO 通过claims获取到当前用户的可访问API权限字符串
                //String apis = (String) claims.get("apis");  //api-user-delete,api-user-update
                //通过handler
                //HandlerMethod h = (HandlerMethod) handler;
                //获取接口上的reqeustmapping注解
                //RequestMapping annotation = h.getMethodAnnotation(RequestMapping.class);
                //获取当前请求接口中的name属性
                //String name = annotation.name();
                //判断当前用户是否具有响应的请求权限
                //if(apis.contains(name)) {
                //    request.setAttribute("user_claims",claims);
                //    return true;
                //}else {
                //    throw new CommonException(ResultCode.INVALID_TOKEN);
                //}
                //if(claims==null){
                //    throw new CommonException(ResultCode.INVALID_TOKEN);
                //}
            }
        }
        throw new CommonException(ResultCode.NO_TOKEN);
    }

}
