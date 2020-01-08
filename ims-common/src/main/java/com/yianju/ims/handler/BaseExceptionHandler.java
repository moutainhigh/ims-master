package com.yianju.ims.handler;

import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.exception.CommonException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的公共异常处理器
 *      1.声明异常处理器
 *      2.对异常统一处理
 */
@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("请求异常：异常原因为：{}",e.getMessage());
        e.printStackTrace();
        if(e.getClass() == CommonException.class) {
            //类型转型
            CommonException ce = (CommonException) e;
            return  new Result(ce.getResultCode());
        }else if(e.getClass() == MalformedJwtException.class){
            Result result = new Result(ResultCode.INVALID_TOKEN);
        }else if(e.getClass() == ExpiredJwtException.class){
            Result result = new Result(ResultCode.INVALID_TOKEN);
        }else{
            return new Result(ResultCode.SERVER_ERROR);
        }
        return new Result(ResultCode.SERVER_ERROR);
    }

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response,AuthorizationException e) {
        return new Result(ResultCode.UNAUTHORISE);
    }
}
