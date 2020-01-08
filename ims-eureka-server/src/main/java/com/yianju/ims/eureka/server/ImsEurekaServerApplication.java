package com.yianju.ims.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ImsEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsEurekaServerApplication.class, args);
    }

}
