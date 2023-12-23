package com.voyager.controller;

import com.voyager.result.Result;
import com.voyager.service.HistoryService;
import com.voyager.vo.TodayHistoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName HistoryController
 * @Author 26483
 * @Date 2023/12/23 15:47
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/history")
@Api(tags = "历史记录")
@Slf4j
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/today/list/{number}")
    @ApiOperation("task历史记录")
    public Result<List<TodayHistoryVO>> getTodayHistoryList(@PathVariable Long number) {
        log.info("查询历史记录：{}", number);

        List<TodayHistoryVO> todayHistoryList = historyService.getTodayHistoryList(number);
        return Result.success(todayHistoryList);
    }

}
