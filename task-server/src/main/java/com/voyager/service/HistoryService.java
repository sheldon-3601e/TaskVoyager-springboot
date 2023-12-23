package com.voyager.service;

import com.voyager.vo.TodayHistoryVO;

import java.util.List;

/**
 * @ClassName HistoryService
 * @Author 26483
 * @Date 2023/12/23 15:54
 * @Version 1.0
 * @Description TODO
 */
public interface HistoryService {

    /**
     * 获取历史计划列表
     * @return
     */
    List<TodayHistoryVO> getTodayHistoryList(Long number);

}
