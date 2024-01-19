package com.example.itheima.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {
    private Long total;
    private List rows;
}
