package com.voyager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;

/**
 * @ClassName StatisticsMapper
 * @Author 26483
 * @Date 2023/12/23 1:02
 * @Version 1.0
 * @Description TODO
 */
@Mapper
public interface StatisticsMapper {

    /**
     * 查询今日待办数量
     * @param date
     * @return
     */
    @Select("select count(*) from today where create_time = #{date} and status != 0")
    Integer countUnfinished(LocalDate date);

    /**
     * 查询今日完成数量
     * @param date
     * @return
     */
    @Select("select count(*) from today where create_time = #{date} and status = 0")
    Integer countFinish(LocalDate date);

    /**
     * 查询标签的总时间
     * @param tagId
     * @param start
     * @param end
     * @return
     */
    Integer queryTotalTime(Long tagId, LocalDate start, LocalDate end);
}
