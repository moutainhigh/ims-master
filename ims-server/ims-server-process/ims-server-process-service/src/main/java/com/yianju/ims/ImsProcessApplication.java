package com.yianju.ims;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 处理单元应用
 */
@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan(basePackages = "com.yianju.ims.process.interceptor.*")
public class ImsProcessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsProcessApplication.class,args);
    }

}
