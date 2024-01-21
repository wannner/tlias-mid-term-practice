package com.example.itheima.service;

import com.example.itheima.pojo.Emp;
import com.example.itheima.pojo.PageBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public void addEmp(Emp emp);

    public String upload(MultipartFile image) throws IOException;

    public void updateEmp(Emp emp);

    public Emp searchEmpById(int id);
}
