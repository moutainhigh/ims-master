package com.yianju.ims;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 处理单元应用
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@ServletComponentScan(basePackages = "com.yianju.ims.process.interceptor.*")
public class ImsProcessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsProcessApplication.class,args);
    }

}
