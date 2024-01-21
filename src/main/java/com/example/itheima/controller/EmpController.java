package com.example.itheima.controller;

import com.example.itheima.pojo.Emp;
import com.example.itheima.pojo.PageBean;
import com.example.itheima.pojo.Result;
import com.example.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/emps")
    private Result addEmp(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return Result.success();
    }

    @PostMapping("/upload")
    private Result upload(MultipartFile image) throws IOException {
        log.info("上传图片，参数：{}", image.getOriginalFilename());
        String url = empService.upload(image);
        return Result.success(url);
    }

    @GetMapping("/emps/{id}")
    private Result searchEmpById(@PathVariable("id") int id) {
        log.info("查询id为{}的员工信息", id);
        return Result.success(empService.searchEmpById(id));
    }


    @PutMapping("/emps")
    private Result updateEmp(@RequestBody Emp emp) {
        log.info("更新员工，参数：{}", emp);
        empService.updateEmp(emp);
        return Result.success();
    }

}
