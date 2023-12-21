package com.voyager.mapper;


import com.voyager.dto.FutureSaveDTO;
import com.voyager.entity.Future;
import com.voyager.vo.FutureQueryVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author 26483
* @description 针对表【future】的数据库操作Mapper
* @createDate 2023-12-13 16:26:13
* @Entity generator.employee.Future
*/
@Mapper
public interface FutureMapper {

    /**
     * 查询未来计划
     *
     * @param userId
     * @return
     */
    List<FutureQueryVO> queryFuture(Long userId);

    /**
     * 删除未来计划
     * @param id
     * @param userId
     */
    @Delete("delete from future where id = #{id} and user_id = #{userId}")
    void deleteFuture(Long id, Long userId);

    /**
     * 完成未来计划
     *
     * @param id
     * @param userId
     * @param completed
     */
    @Update("update future set status = #{completed} where id = #{id} and user_id = #{userId}")
    void finishFuture(Long id, Long userId, Integer completed);

    /**
     * 添加未来计划
     * @param future
     */
    Long save(Future future);

    /**
     * 更新未来计划
     * @param futureSaveDTO
     */
    void updateById(FutureSaveDTO futureSaveDTO);
}




