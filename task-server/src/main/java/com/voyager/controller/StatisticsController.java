package com.voyager.controller;

import com.voyager.result.Result;
import com.voyager.service.StatisticsService;
import com.voyager.vo.TagDataVO;
import com.voyager.vo.TodayDataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName StatisticsController
 * @Author 26483
 * @Date 2023/12/23 1:00
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/statistics")
@Api(tags = "统计接口")
@Slf4j
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/today/{number}")
    @ApiOperation(value = "获取每日计划的完成情况")
    public Result<TodayDataVO> getToday(@PathVariable Integer number) {
        log.info("获取每日计划的完成情况");

        TodayDataVO todayDataVO = statisticsService.getToday(number);
        return Result.success(todayDataVO);
    }

    @GetMapping("/tag/{number}")
    @ApiOperation(value = "获取标签的时间占比")
    public Result<List<TagDataVO>> getTagTime(@PathVariable Integer number) {
        log.info("获取每日计划的完成情况");

        List<TagDataVO> tagDataVOList = statisticsService.getTagTime(number);
        return Result.success(tagDataVOList);
    }


}
