package com.voyager.mapper;

import com.voyager.entity.Detail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 26483
* @description 针对表【detail】的数据库操作Mapper
* @createDate 2023-12-13 16:26:13
* @Entity generator.employee.Detail
*/
@Mapper
public interface DetailMapper  {

    /**
     * 批量插入
     * @param detailList
     */
    void insertBatch(List<Detail> detailList);

    /**
     * 根据未来计划id删除
     * @param futureId
     */
    @Delete("delete from detail where future_id = #{futureId}")
    void deleteByFutureId(Long futureId);
}




