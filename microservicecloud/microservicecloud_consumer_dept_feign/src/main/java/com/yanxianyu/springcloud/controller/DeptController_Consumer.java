package com.yanxianyu.springcloud.controller;

import com.yanxianyu.springcloud.entities.Dept;
import com.yanxianyu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
    @Autowired
    private DeptClientService clientService;

    @RequestMapping(value = "/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno") Long deptno){
        return this.clientService.get(deptno);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return this.clientService.list();
    }

    @RequestMapping(value = "consumer/dept/add")
    public Object add(Dept dept){
        return this.clientService.add(dept);
    }

}
