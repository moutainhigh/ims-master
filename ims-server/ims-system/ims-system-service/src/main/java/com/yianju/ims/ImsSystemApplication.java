package com.yianju.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsSystemApplication.class,args);
    }
}
