package com.voyager.service.impl;

import com.voyager.mapper.StatisticsMapper;
import com.voyager.mapper.TagMapper;
import com.voyager.mapper.TodayMapper;
import com.voyager.mapper.TodayTimeMapper;
import com.voyager.service.StatisticsService;
import com.voyager.vo.TagDataVO;
import com.voyager.vo.TagQueryVo;
import com.voyager.vo.TodayDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StatisticsServiceImpl
 * @Author 26483
 * @Date 2023/12/23 1:02
 * @Version 1.0
 * @Description TODO
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;
    @Autowired
    private TodayMapper todayMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private TodayTimeMapper todayTimeMapper;

    @Override
    public TodayDataVO getToday(Integer number) {

        List<String> xAxis = new ArrayList<>();
        List<Integer> totalData = new ArrayList<>();
        List<Integer> finishData = new ArrayList<>();

        // 解析时间区间
        LocalDate now = LocalDate.now();

        // 循环查询每日计划完成情况
        for (int i = 0; i < number; i++) {
            // 获取每日的日期
            now = now.minusDays(1);

            Integer total = statisticsMapper.countTotal(now);
            Integer finish = statisticsMapper.countFinish(now);

            // 封装数据
            xAxis.add(now.toString());
            totalData.add(total);
            finishData.add(finish);
        }

        return TodayDataVO.builder()
                .xAxis(xAxis)
                .totalData(totalData)
                .finishData(finishData)
                .build();
    }

    @Override
    public List<TagDataVO> getTagTime(Integer number) {

        // 获取标签列表
        // TODO: 获取当前用户id
        Long userId = 1L;

        // 解析时间
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(number + 1);

        List<TagQueryVo> tagQueryVoList = tagMapper.queryByUserId(userId);

        // 循环查询每个标签的时间占比
        ArrayList<TagDataVO> tagDataVOS = new ArrayList<>();
        for (TagQueryVo tagQueryVo : tagQueryVoList) {
            // 获取标签id
            Long tagId = tagQueryVo.getId();

            // 查询每个标签的时间占比
            Integer totalTime = statisticsMapper.queryTotalTime(tagId, start, end);

            // 封装数据
            TagDataVO tagDataVO = TagDataVO.builder()
                    .name(tagQueryVo.getName())
                    .value(totalTime == null ? 0 : totalTime)
                    .build();
            tagDataVOS.add(tagDataVO);
        }

        return tagDataVOS;
    }
}
