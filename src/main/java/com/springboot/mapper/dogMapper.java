package com.springboot.mapper;

import com.springboot.bean.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

@Component
@Mapper//指定这是一个操作数据库的mapper
public interface dogMapper {

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into dog(name,age) values(#{name},#{age})")//定义sql语句
    public int insertDog(String name,Integer age);

    public user selectUser(Integer id);
}
