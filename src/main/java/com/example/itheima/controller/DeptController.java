package com.example.itheima.controller;

import com.example.itheima.pojo.Dept;
import com.example.itheima.pojo.Result;
import com.example.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/depts")
    public Result getDeptList() {
        List<Dept> list=deptService.getDeptList();
        log.info("显示成功");
        return Result.success(list);
    }
}
