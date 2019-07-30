package com.yanxianyu.springcloud;

import com.yanxianyu.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)//配置既生效
public class DeptConsumer_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_App.class,args);
    }
}
