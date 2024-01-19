package com.example.itheima.controller;

import com.example.itheima.mapper.DeptMapper;
import com.example.itheima.pojo.Dept;
import com.example.itheima.pojo.Result;
import com.example.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping
    private Result getDeptList() {
        List<Dept> list=deptService.getDeptList();
        log.info("显示成功");
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    private Result deleteDept(@PathVariable("id") int id){
        deptService.deleteDept(id);
        return Result.success();
    }

    @PostMapping
    private Result addDept(@RequestBody Dept dept){
        //记录日志
        log.info("新增部门：{}",dept);
        //调用service层添加功能
        deptService.addDept(dept);
        //响应
        return Result.success();
    }

    @GetMapping("/{id}")
    private Result searchById(@PathVariable("id")int id){
        Dept dept=deptService.getDeptById(id);
        return Result.success(dept);
    }


}
