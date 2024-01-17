package com.example.itheima.service.impl;

import com.example.itheima.mapper.DeptMapper;
import com.example.itheima.pojo.Result;
import com.example.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List getDeptList() {
        return deptMapper.getDeptList();
    }
}
