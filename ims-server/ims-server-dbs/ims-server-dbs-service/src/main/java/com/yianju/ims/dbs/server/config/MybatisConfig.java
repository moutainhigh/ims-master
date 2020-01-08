package com.yianju.ims.dbs.server.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.yianju.ims.util.JwtUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.yianju.ims.dbs.server.mapper")
@Configuration
public class MybatisConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //@Bean
    //public JwtUtil createJwtUtil() { return new JwtUtil(); }
}
