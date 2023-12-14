package com.voyager.service.impl;


import com.voyager.dto.TodayAdd;
import com.voyager.dto.TodayQueryDTO;
import com.voyager.entity.Today;
import com.voyager.mapper.TodayMapper;
import com.voyager.service.TodayService;
import com.voyager.vo.TodayQueryVo;
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

    @Override
    public void add(TodayAdd todayAdd) {
        Long id = System.currentTimeMillis();
        Today today = Today.builder()
                .id(id)
                .name(todayAdd.getName())
                .status(1)
                .createTime(LocalDateTime.now())
                .userId(1L)
                .tagId(todayAdd.getTagId())
                .priority(1)
                .build();
        todayMapper.add(today);
    }

    @Override
    public List<Today> query() {
        Long userId = 1L;
        LocalDate today = LocalDate.now();
        TodayQueryDTO todayQueryDTO = new TodayQueryDTO();
        todayQueryDTO.setUserId(userId);
        todayQueryDTO.setLocalDate(today);

        return todayMapper.query(todayQueryDTO);
    }

    @Override
    public TodayQueryVo queryById(Long id) {
        Today today = todayMapper.queryById(id);
        return TodayQueryVo.builder()
                .id(today.getId())
                .name(today.getName())
                .tagId(today.getTagId())
                .priority(today.getPriority())
                .build();
    }
}




