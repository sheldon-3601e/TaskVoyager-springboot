package com.voyager.service;


import com.voyager.dto.TodayAdd;
import com.voyager.entity.Today;
import com.voyager.vo.TodayQueryVo;

import java.util.List;

/**
* @author 26483
* @description 针对表【today】的数据库操作Service
* @createDate 2023-12-13 16:26:13
*/
public interface TodayService {

    /**
     * 添加今日代办
     * @param todayAdd
     */
    void add(TodayAdd todayAdd);

    /**
     * 查询今日代办
     *
     * @return
     */
    List<Today> query();

    /**
     * 根据id查询今日代办
     * @param id
     * @return
     */
    TodayQueryVo queryById(Long id);
}
