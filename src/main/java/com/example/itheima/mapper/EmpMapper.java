package com.example.itheima.mapper;

import com.example.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Insert("insert into tlias.emp(username,name, gender, image, job, entrydate, dept_id, create_time, update_time)  values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void addEmp(Emp emp);

    @Update("update tlias.emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    public void updateEmp(Emp emp);

    @Select("select * from emp where id=#{id}")
    public Emp searchEmpById(int id);

    @Select("select * from emp where username=#{username} and password=#{password}")
    public Emp login(Emp emp);

}
