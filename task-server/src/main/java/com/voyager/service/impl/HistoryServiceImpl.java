package com.voyager.service.impl;

import com.voyager.entity.Today;
import com.voyager.mapper.HistoryMapper;
import com.voyager.service.HistoryService;
import com.voyager.vo.TodayHistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HistoryServiceImpl
 * @Author 26483
 * @Date 2023/12/23 15:54
 * @Version 1.0
 * @Description TODO
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<TodayHistoryVO> getTodayHistoryList(Long number) {

        // 解析日期
        LocalDate now = LocalDate.now();

        List<TodayHistoryVO> todayHistoryVOList = new ArrayList<>();

        // 循环查询计划
        for (int i = 0; i < number; i++) {
            now = now.minusDays(1);
            List<Today> todayList  = historyMapper.getTodayByDate(now);
            TodayHistoryVO todayHistoryVO = TodayHistoryVO.builder()
                    .localDate(now)
                    .todayList(todayList)
                    .build();
            todayHistoryVOList.add(todayHistoryVO);
        }

        return todayHistoryVOList;
    }
}
