package com.yanxianyu.springcloud.controller;

import com.yanxianyu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

//    public static final  String REST_PREFIX = "http://localhost:8001";
    public static final  String REST_PREFIX = "http://MICROSERVICECLOUD-DEPT";
    /**
     * 使用restTemplate访问restful接口非常的简单粗暴无脑。
     * （url，request Map，responseBean.class分别代表，rest请求地址，请求参数，返回类型）
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno") Long deptno){
        return restTemplate.getForObject(REST_PREFIX+"/dept/get/"+deptno,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_PREFIX+"/dept/list",List.class);
    }
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_PREFIX+"/dept/discovery",Object.class);
    }


}
