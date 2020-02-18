package com.yianju.ims.system.config;

import com.yianju.ims.interceptor.JwtInterceptor;
import com.yianju.ims.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class BeanFactory {

    @Bean
    public JwtUtil createJwtUtil() { return new JwtUtil(); }


    @Bean
    public JwtInterceptor createJwtInterceptor(){
        return new JwtInterceptor();
    }


}
