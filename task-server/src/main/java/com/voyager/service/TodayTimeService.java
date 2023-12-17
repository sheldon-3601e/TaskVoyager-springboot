package com.voyager.service;



/**
* @author 26483
* @description 针对表【today_time】的数据库操作Service
* @createDate 2023-12-13 16:26:13
*/
public interface TodayTimeService  {

    /**
     * 开始计时
     * @param todayId
     */
    void start(Long todayId);

    /**
     * 结束计时
     * @param todayId
     */
    void stop(Long todayId);
}
