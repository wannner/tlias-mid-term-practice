package com.example.itheima.service.impl;

import com.example.itheima.mapper.DeptMapper;
import com.example.itheima.pojo.Dept;
import com.example.itheima.pojo.Result;
import com.example.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List getDeptList() {
        return deptMapper.getDeptList();
    }

    @Override
    public void deleteDept(int id) {
        deptMapper.deleteDept(id);
    }

    @Override
    public void addDept(Dept dept) {
        //补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用持久层增加功能
        deptMapper.addDept(dept);
    }
}
