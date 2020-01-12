package com.yianju.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


// @SpringBootApplication(scanBasePackages = "com.yianju.ims")
@SpringBootApplication
@EnableEurekaClient
public class ImsServerDbsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsServerDbsServiceApplication.class,args);
    }
}
