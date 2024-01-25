package com.example.itheima.controller;

import com.example.itheima.pojo.Emp;
import com.example.itheima.pojo.Result;
import com.example.itheima.service.EmpService;
import com.example.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp login = empService.login(emp);
        if (!Objects.isNull(login)) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("name", emp.getName());
            claims.put("username", emp.getUsername());

            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
            return Result.success(jwt);
        } else return Result.error("用户名或密码错误");
    }


}
