package com.voyager.mapper;


import com.voyager.dto.TodayQueryDTO;
import com.voyager.dto.TodayUpdateDTO;
import com.voyager.entity.Today;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 26483
 * @description 针对表【today】的数据库操作Mapper
 * @createDate 2023-12-13 16:26:13
 * @Entity generator.employee.Today
 */
@Mapper
public interface TodayMapper {

    void add(Today today);

    List<Today> query(TodayQueryDTO todayQueryDTO);

    @Select("select * from today where id = #{id}")
    Today queryById(Long id);

    void updateById(TodayUpdateDTO todayUpdateDTO);

    @Delete("delete from today where id = #{id}")
    void deleteById(Long id);

    @Update("update today set status = 2 where id = #{id}")
    void completeById(Long id);
}




