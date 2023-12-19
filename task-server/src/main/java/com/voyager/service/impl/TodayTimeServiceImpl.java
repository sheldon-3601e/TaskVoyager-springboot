package com.voyager.service.impl;


import com.voyager.constant.StatusConstant;
import com.voyager.entity.TodayTime;
import com.voyager.mapper.TodayMapper;
import com.voyager.mapper.TodayTimeMapper;
import com.voyager.service.TodayTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.Temporal;

/**
 * @author 26483
 * @description 针对表【today_time】的数据库操作Service实现
 * @createDate 2023-12-13 16:26:13
 */
@Service
public class TodayTimeServiceImpl implements TodayTimeService {

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

    @Override
    public void stop(Long todayId) {
        // 结束计时，并计算时长
        LocalTime stopTime = LocalTime.now();

        // 保存开始时间
        TodayTime todayTime = todayTimeMapper.getById(todayId);
        // 将 java.util.Date 转换为 Instant
        Instant startInstant = todayTime.getStartTime().toInstant();

        // 将 Instant 转换为 LocalTime
        LocalTime startTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault()).toLocalTime();

        // 计算时长，获取 Duration 对象
        Duration duration = Duration.between(startTime, stopTime);

        // 获取时长的小时数
        long hours = duration.toMinutes();


        // 更新数据库中的结束时间和时长
        todayTimeMapper.stop(todayId, stopTime, hours);

        // 修改today状态
        todayMapper.updateStatusById(todayId, StatusConstant.UNCOMPLETED);

        // 修改今日状态为未完成
        todayMapper.updateStatusById(todayId, StatusConstant.UNCOMPLETED);
    }
}




