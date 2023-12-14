package com.voyager.service.impl;


import com.voyager.dto.TodayAdd;
import com.voyager.dto.TodayQueryDTO;
import com.voyager.dto.TodayUpdateDTO;
import com.voyager.entity.Today;
import com.voyager.mapper.TodayMapper;
import com.voyager.service.TodayService;
import com.voyager.vo.TodayQueryCompletedVO;
import com.voyager.vo.TodayQueryUncompletedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public List<Today> queryCompleted() {
        // TODO 获取用户id
        Long userId = 1L;
        LocalDate today = LocalDate.now();
        TodayQueryDTO todayQueryDTO = new TodayQueryDTO();
        todayQueryDTO.setUserId(userId);
        todayQueryDTO.setLocalDate(today);
        todayQueryDTO.setStatus(1);

        return todayMapper.query(todayQueryDTO);
    }

    @Override
    public TodayQueryCompletedVO queryById(Long id) {
        Today today = todayMapper.queryById(id);
        return TodayQueryCompletedVO.builder()
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
    }

    @Override
    public void completeById(Long id) {
        todayMapper.completeById(id);
    }

    @Override
    public List<TodayQueryUncompletedVO> queryUncompleted() {
        // TODO 获取用户id
        Long userId = 1L;
        LocalDate today = LocalDate.now();
        TodayQueryDTO todayQueryDTO = new TodayQueryDTO();
        todayQueryDTO.setUserId(userId);
        todayQueryDTO.setLocalDate(today);
        todayQueryDTO.setStatus(2);

        List<Today> todayList = todayMapper.query(todayQueryDTO);
        List<TodayQueryUncompletedVO> list = new ArrayList<>();
        for (Today t : todayList) {
            TodayQueryUncompletedVO todayQueryUncompletedVO = TodayQueryUncompletedVO.builder()
                    .id(t.getId())
                    .name(t.getName())
                    .build();
            list.add(todayQueryUncompletedVO);
        }
        return list;
    }
}




