package com.voyager.controller;

import com.voyager.dto.TodayAdd;
import com.voyager.dto.TodayUpdateDTO;
import com.voyager.entity.Today;
import com.voyager.mapper.TodayMapper;
import com.voyager.result.Result;
import com.voyager.service.TodayService;
import com.voyager.vo.TodayQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result add(@RequestBody TodayAdd todayAdd) {
        log.info("添加今日代办：{}", todayAdd);

        todayService.add(todayAdd);
        return Result.success();
    }

    @GetMapping("/query")
    public Result<List<Today>> query() {
        log.info("查询今日代办");

        List<Today> todayList = todayService.query();
        return Result.success(todayList);
    }

    @GetMapping("/query/{id}")
    @ApiOperation("根据id查询今日代办")
    public Result<TodayQueryVo> queryById(@PathVariable("id") Long id) {
        log.info("根据id查询今日代办：{}", id);

        TodayQueryVo todayQueryVo = todayService.queryById(id);
        return Result.success(todayQueryVo);
    }

    @PostMapping("/update")
    @ApiOperation("根据id修改今日代办")
    public Result updateById(@RequestBody TodayUpdateDTO todayUpdateDTO) {
        log.info("根据id修改今日代办：{}", todayUpdateDTO);

        todayService.updateById(todayUpdateDTO);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("根据id删除今日代办")
    public Result deleteById(@PathVariable Long id) {
        log.info("根据id删除今日代办：{}", id);

        todayService.deleteById(id);
        return Result.success();
    }

}
