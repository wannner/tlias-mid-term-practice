package com.example.itheima.service.impl;

import com.example.itheima.mapper.EmpMapper;
import com.example.itheima.pojo.Emp;
import com.example.itheima.pojo.PageBean;
import com.example.itheima.service.EmpService;
import com.example.itheima.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Autowired
    AliOSSUtils aliOSSUtils;

    @Override
    public PageBean listSearchEmp(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        List list = empMapper.listSearchEmp(name, gender, begin, end, (page - 1) * pageSize, pageSize);
        long total = empMapper.countSearchEmp();
        PageBean pageBean = new PageBean();
        pageBean.setRows(list);
        pageBean.setTotal(total);
        return pageBean;
    }

    @Override
    public void deleteEmp(List ids) {
        empMapper.deleteEmp(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        ;
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
    }

    @Override
    public String upload(MultipartFile image) throws IOException {
        return aliOSSUtils.upload(image);
    }
}
