package com.voyager.mapper;


import com.voyager.dto.TodayQueryDTO;
import com.voyager.dto.TodayUpdateDTO;
import com.voyager.entity.Today;
import com.voyager.vo.TodayQueryVO;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
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

    @Select("select * from today where id = #{id}")
    Today queryById(Long id);

    void updateById(TodayUpdateDTO todayUpdateDTO);

    @Delete("delete from today where id = #{id}")
    void deleteById(Long id);

    @Update("update today set status = #{status} where id = #{id}")
    void updateStatusById(Long id, Integer status);

    /**
     * 查询今日代办
     * @param userId
     * @param today
     * @return
     */
    @Select("select id, user_id, tag_id, name, priority, status, create_time from today" +
            " where user_id = #{userId} and create_time = #{today} ")
    List<TodayQueryVO> query(Long userId, LocalDate today);


}




