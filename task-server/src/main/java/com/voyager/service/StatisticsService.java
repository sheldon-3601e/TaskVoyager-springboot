package com.voyager.service;

import com.voyager.vo.TagDataVO;
import com.voyager.vo.TodayDataVO;

import java.util.List;

/**
 * @ClassName StatisticsService
 * @Author 26483
 * @Date 2023/12/23 1:01
 * @Version 1.0
 * @Description TODO
 */
public interface StatisticsService {

    /**
     * 获取每日计划的完成情况
     * @param number
     * @return
     */
    TodayDataVO getToday(Integer number);

    /**
     * 获取标签的时间占比
     *
     * @param number
     * @return
     */
    List<TagDataVO> getTagTime(Integer number);
}
