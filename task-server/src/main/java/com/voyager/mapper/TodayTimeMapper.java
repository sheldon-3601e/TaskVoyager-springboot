package com.voyager.mapper;


import com.voyager.entity.TodayTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.time.LocalTime;

/**
* @author 26483
* @description 针对表【today_time】的数据库操作Mapper
* @createDate 2023-12-13 16:26:13
* @Entity generator.employee.TodayTime
*/
@Mapper
public interface TodayTimeMapper {

    @Insert("insert into today_time " +
            "(id, user_id, tag_id, today_id) " +
            "VALUES (#{id}, #{userId}, #{tagId}, #{todayId})")
    void save(TodayTime todayTime);

    @Update("update today_time set start_time = #{currentTime} where today_id = #{todayId}")
    void start(Long todayId, LocalTime currentTime);
}




