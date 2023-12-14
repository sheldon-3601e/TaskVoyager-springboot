package com.voyager.service;


import com.voyager.dto.TodayAdd;

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
    void addTODO(TodayAdd todayAdd);
}
