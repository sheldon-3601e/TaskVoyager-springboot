package com.voyager.service;


import com.voyager.dto.FutureSaveDTO;
import com.voyager.vo.FutureQueryVO;

import java.util.List;

/**
* @author 26483
* @description 针对表【future】的数据库操作Service
* @createDate 2023-12-13 16:26:13
*/
public interface FutureService{

    /**
     * 查询未来计划
     *
     * @return
     */
    List<FutureQueryVO> queryFuture();

    /**
     * 删除未来计划
     * @param id
     */
    void deleteFuture(Long id);

    /**
     * 完成未来计划
     * @param id
     */
    void finishFuture(Long id);

    /**
     * 保存未来计划
     * @param futureSaveDTO
     */
    void save(FutureSaveDTO futureSaveDTO);
}
