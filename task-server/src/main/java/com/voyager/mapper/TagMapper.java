package com.voyager.mapper;


import com.voyager.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 26483
* @description 针对表【tag】的数据库操作Mapper
* @createDate 2023-12-13 16:26:13
* @Entity generator.employee.Tag
*/
@Mapper
public interface TagMapper  {

    @Select("select * from tag where user_id = #{userId}")
    List<Tag> queryByUserId(Long userId);
}




