package com.voyager.mapper;


import com.voyager.dto.TagDTO;
import com.voyager.entity.Tag;
import com.voyager.vo.TagQueryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author 26483
* @description 针对表【tag】的数据库操作Mapper
* @createDate 2023-12-13 16:26:13
* @Entity generator.employee.Tag
*/
@Mapper
public interface TagMapper  {

    @Select("select id, user_id, name from tag where user_id = #{userId}")
    List<TagQueryVo> queryByUserId(Long userId);
    
    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    @Select("select * from tag where id = #{id}")
    Tag selectById(Long id);

    /**
     * 根据内容查询标签
     */
    @Select("select * from tag where name = #{name}")
    Tag selectByName(String name);

    /**
     * 根据id修改标签
     */
    @Update("update tag set name = #{name} where id = #{id}")
    void updateTag(TagDTO tagDTO);

    /**
     * 添加标签
     */
    @Insert("insert into tag (id, user_id, name) values (#{id}, #{userId}, #{name})")
    void saveTag(Tag tag);

    @Delete("delete from tag where id = #{id}")
    void deleteTag(Long id);
}




