package com.yanxianyu.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//spring进行类定义
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced//配置负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule myRule(){
        //用我们选择的随机算法
        return new RandomRule();
    }
}
