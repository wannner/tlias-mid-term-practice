package com.example.itheima.mapper;

import com.example.itheima.pojo.Dept;
import com.example.itheima.pojo.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;


@Mapper
public interface DeptMapper {
    @Select("select * from tlias.dept")
    public List<Dept> getDeptList();

    @Delete("delete from tlias.dept where id=#{id}")
    public void deleteDept(int id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name},now(),now())")
    public void addDept(Dept dept);

    @Select("select * from dept where id=#{id}")
    public Dept getDeptById(int id);


}
