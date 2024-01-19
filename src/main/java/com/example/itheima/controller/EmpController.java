package com.example.itheima.controller;

import com.example.itheima.pojo.PageBean;
import com.example.itheima.pojo.Result;
import com.example.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/emps")
    private Result listSearchEmp(String name,
                                 Integer gender,
                                 @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                 @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                                 @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.listSearchEmp(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/emps/{ids}")
    private Result deleteEmp(@PathVariable List<Integer> ids) {
        log.info("删除员工，参数：{}", ids);
        empService.deleteEmp(ids);
        return Result.success();
    }

    //批量删除


}
