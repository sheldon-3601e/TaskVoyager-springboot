package com.voyager.mapper;


import com.voyager.entity.TodayTime;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
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

    @Update("update today_time set stop_time = #{stopTime}, time = #{hours} where today_id = #{todayId}")
    void stop(Long todayId, LocalTime stopTime, long hours);

    @Select("select * from today_time where today_id = #{todayId}")
    TodayTime getById(Long todayId);

    @Delete("delete from today_time where today_id = #{id}")
    void deleteByTodayId(Long id);

    /**
     * 查询某个标签在某个时间段内的总时间
     * @param tagId
     * @param start
     * @param end
     * @return
     */
    Integer queryTotalTime(Long tagId, LocalDate start, LocalDate end);
}




