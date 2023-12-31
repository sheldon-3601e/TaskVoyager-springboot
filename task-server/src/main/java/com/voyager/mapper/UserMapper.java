package com.voyager.mapper;

import com.voyager.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author 26483
* @description 针对表【employee】的数据库操作Mapper
* @createDate 2023-12-13 16:25:33
* @Entity generator.employee.Employee
*/
@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User login(String username);
}




