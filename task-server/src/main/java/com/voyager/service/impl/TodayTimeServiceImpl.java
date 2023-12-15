package com.voyager.service.impl;


import com.voyager.constant.StatusConstant;
import com.voyager.mapper.TodayMapper;
import com.voyager.mapper.TodayTimeMapper;
import com.voyager.service.TodayTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
* @author 26483
* @description 针对表【today_time】的数据库操作Service实现
* @createDate 2023-12-13 16:26:13
*/
@Service
public class TodayTimeServiceImpl  implements TodayTimeService {

    @Autowired
    private TodayTimeMapper todayTimeMapper;
    @Autowired
    private TodayMapper todayMapper;

    @Override
    public void start(Long todayId) {
        LocalTime currentTime = LocalTime.now();

        // 保存开始时间
        todayTimeMapper.start(todayId, currentTime);

        // 修改今日状态为进行中
        todayMapper.updateStatusById(todayId, StatusConstant.DOING);
    }
}




