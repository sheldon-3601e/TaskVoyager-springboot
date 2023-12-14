package com.voyager.controller;

import com.voyager.dto.TodayAdd;
import com.voyager.mapper.TodayMapper;
import com.voyager.result.Result;
import com.voyager.service.TodayService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TodayController
 * @Author 26483
 * @Date 2023/12/14 14:49
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/today")
@Api(tags = "今日待办相关接口")
@Slf4j
public class TodayController {

    @Autowired
    private TodayService todayService;

    @PostMapping("/add")
    public Result addTODO(@RequestBody TodayAdd todayAdd) {
        log.info("添加今日代办：{}", todayAdd);

        todayService.addTODO(todayAdd);
        return Result.success();
    }

}
