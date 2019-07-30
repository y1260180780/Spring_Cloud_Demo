package com.yanxianyu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yanxianyu.springcloud.entities.Dept;
import com.yanxianyu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService = null;

    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping(value = "/dept/get/{deptno}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")//一旦调用方法发生错误，会自动调用注解标注好的方法
    public Dept get(@PathVariable("deptno") Long deptno) throws Exception {
        Dept service = deptService.findById(deptno);
        if(service == null){
            throw new RuntimeException("该ID"+deptno+"没有对应的信息");
        }
        return service;
    }

    public Dept processHystrix_Get(@PathVariable("deptno") Long deptno){
        return new Dept().setDeptno(deptno).setDname("该ID"+deptno+"没有对应的信息@HystrixCommand").setDb_source("no databases");
    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list(){
        return deptService.findAll();
    }

    @GetMapping(value = "/dept/discovery")
    public Object discovery(){
        //拿到所有注册在上面的服务
        List<String> services = client.getServices();
        System.out.println("&&&&&"+services);
        List<ServiceInstance> microservicecloud_dept = client.getInstances("MICROSERVICECLOUD_DEPT");
        for (ServiceInstance element : microservicecloud_dept) {
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.client;

    }

}
