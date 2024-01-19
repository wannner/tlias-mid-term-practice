package com.example.itheima.service;

import com.example.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    public PageBean listSearchEmp(String name,
                                  Integer gender,
                                  LocalDate begin,
                                  LocalDate end,
                                  Integer page,
                                  Integer pageSize);

    public void deleteEmp(List id);
}
