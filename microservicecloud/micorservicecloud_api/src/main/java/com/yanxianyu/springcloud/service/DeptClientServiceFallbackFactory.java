package com.yanxianyu.springcloud.service;

import com.yanxianyu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept deptEntity) {
                return false;
            }

            @Override
            public Dept get(Long deptno) {
                return new Dept().setDeptno(deptno).setDname("该ID"+deptno+"没有对应的信息已经被降级，暂停服务").setDb_source("no databases");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
