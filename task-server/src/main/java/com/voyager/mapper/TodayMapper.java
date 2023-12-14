package com.voyager.mapper;


import com.voyager.entity.Today;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 26483
 * @description 针对表【today】的数据库操作Mapper
 * @createDate 2023-12-13 16:26:13
 * @Entity generator.employee.Today
 */
@Mapper
public interface TodayMapper {

    void addTODO(@Param("today") Today today);
}




