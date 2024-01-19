package com.example.itheima.service;
import java.util.*;

import com.example.itheima.pojo.Dept;
import com.example.itheima.pojo.Result;
import org.springframework.stereotype.Service;

public interface DeptService {

    public List getDeptList();

    public void deleteDept(int id);

    public void addDept(Dept dept);

    public Dept getDeptById(int id);
}
