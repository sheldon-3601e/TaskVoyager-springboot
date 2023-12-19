package com.voyager.controller;

import com.voyager.result.Result;
import com.voyager.service.TodayTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TimeController
 * @Author 26483
 * @Date 2023/12/15 14:54
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/time")
@Slf4j
@Api(tags = "时间管理")
public class TodayTimeController {

    @Autowired
    private TodayTimeService todayTimeService;

    @PutMapping("/start/{todayId}")
    @ApiOperation("开始计时")
    public Result start(@PathVariable Long todayId) {
        log.info("开始计时：{}", todayId);

        todayTimeService.start(todayId);
        return Result.success();
    }

    @PutMapping("/end/{todayId}")
    @ApiOperation("结束计时")
    public Result stop(@PathVariable Long todayId) {
        log.info("结束计时：{}", todayId);
        todayTimeService.stop(todayId);
        return Result.success();
    }

}
