package com.voyager.service.impl;


import com.voyager.constant.StatusConstant;
import com.voyager.context.BaseContext;
import com.voyager.dto.TodayAdd;
import com.voyager.dto.TodayUpdateDTO;
import com.voyager.entity.Today;
import com.voyager.entity.TodayTime;
import com.voyager.mapper.TodayMapper;
import com.voyager.mapper.TodayTimeMapper;
import com.voyager.service.TodayService;
import com.voyager.vo.TodayByIdVO;
import com.voyager.vo.TodayQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 26483
 * @description 针对表【today】的数据库操作Service实现
 * @createDate 2023-12-13 16:26:13
 */
@Service
public class TodayServiceImpl implements TodayService {

    @Autowired
    private TodayMapper todayMapper;
    @Autowired
    private TodayTimeMapper todayTimeMapper;

    @Override
    public void add(TodayAdd todayAdd) {

        Long userId = BaseContext.getCurrentId();
        // 生成时间戳作为id
        Long id = System.currentTimeMillis();
        Today today = Today.builder()
                .id(id)
                .userId(userId)
                .name(todayAdd.getName())
                .status(StatusConstant.UNCOMPLETED)
                .createTime(LocalDateTime.now())
                .tagId(todayAdd.getTagId())
                .priority(todayAdd.getPriority())
                .build();
        // 添加今日代办
        todayMapper.add(today);

        id = System.currentTimeMillis();
        TodayTime todayTime = TodayTime.builder()
                .id(id)
                .userId(userId)
                .tagId(todayAdd.getTagId())
                .todayId(today.getId())
                .build();
        todayTimeMapper.save(todayTime);
    }

    @Override
    public TodayByIdVO queryById(Long id) {
        Today today = todayMapper.queryById(id);
        return TodayByIdVO.builder()
                .id(today.getId())
                .name(today.getName())
                .tagId(today.getTagId())
                .priority(today.getPriority())
                .build();
    }

    @Override
    public void updateById(TodayUpdateDTO todayUpdateDTO) {

        todayMapper.updateById(todayUpdateDTO);

    }

    @Override
    public void deleteById(Long id) {
        todayMapper.deleteById(id);

        todayTimeMapper.deleteByTodayId(id);
    }

    @Override
    public void completeById(Long id) {
        todayMapper.updateStatusById(id, StatusConstant.COMPLETED);
    }


    @Override
    public List<TodayQueryVO> query() {

        Long userId = BaseContext.getCurrentId();

        // 获取今日代办时间
        LocalDate today = LocalDate.now();

        List<TodayQueryVO> queryVOList =  todayMapper.query(userId, today);

        return queryVOList;

    }
}




