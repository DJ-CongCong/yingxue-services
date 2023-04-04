package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiSmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiSmsApplication.class,args);
    }
}
