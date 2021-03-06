package com.yanxianyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注入eureka中
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//对熔断机制的支持
public class DeptProvider_Hystrix_8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_Hystrix_8001_App.class,args);
    }
}
