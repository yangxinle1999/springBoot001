package com.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface catMapper {
    public int insertCat(@Param("name") String name,@Param("age") Integer age);
}
