package com.yanxianyu.springcloud.service.impl;

import com.yanxianyu.springcloud.dao.DeptDao;
import com.yanxianyu.springcloud.entities.Dept;
import com.yanxianyu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept deptEntity) {
        return deptDao.addDept(deptEntity);
    }

    @Override
    public Dept findById(Long deptNo) {
        return deptDao.findById(deptNo);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
