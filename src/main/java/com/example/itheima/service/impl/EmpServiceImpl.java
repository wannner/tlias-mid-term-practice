package com.example.itheima.service.impl;

import com.example.itheima.mapper.EmpMapper;
import com.example.itheima.pojo.PageBean;
import com.example.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean listSearchEmp(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        List list = empMapper.listSearchEmp(name, gender, begin, end, (page - 1) * pageSize, pageSize);
        long total = empMapper.countSearchEmp();
        PageBean pageBean = new PageBean();
        pageBean.setRows(list);
        pageBean.setTotal(total);
        return pageBean;
    }
}
