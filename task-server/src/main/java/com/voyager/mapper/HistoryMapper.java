package com.voyager.mapper;

import com.voyager.entity.Today;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName HistoryMapper
 * @Author 26483
 * @Date 2023/12/23 15:55
 * @Version 1.0
 * @Description TODO
 */
@Mapper
public interface HistoryMapper {

    /**
     * 根据日期查询计划
     * @param now
     * @return
     */
    @Select("select id, name, tag_id from today where create_time = #{now}")
    List<Today> getTodayByDate(LocalDate now);
}
