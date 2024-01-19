package com.example.itheima.mapper;

import com.example.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    public List<Emp> listSearchEmp(String name,
                                   Integer gender,
                                   LocalDate begin,
                                   LocalDate end,
                                   Integer start,
                                   Integer pageSize);

    @Select("select count(*) from tlias.emp")
    public Long countSearchEmp();

    public void deleteEmp(List ids);

}
