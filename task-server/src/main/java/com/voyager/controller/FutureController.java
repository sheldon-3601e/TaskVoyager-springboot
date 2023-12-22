package com.voyager.controller;

import com.voyager.dto.FutureSaveDTO;
import com.voyager.result.Result;
import com.voyager.service.FutureService;
import com.voyager.vo.FutureQueryVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName FutureController
 * @Author 26483
 * @Date 2023/12/17 19:11
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/future")
@Slf4j
public class FutureController {

    @Autowired
    private FutureService futureService;

    @GetMapping("/query")
    @ApiOperation("查询未来计划")
    public Result<List<FutureQueryVO>> queryFuture() {
        log.info("查询未来计划");

        List<FutureQueryVO> queryVOList = futureService.queryFuture();
        return Result.success(queryVOList);
    }

    // 删除未来计划
    @PostMapping("/delete/{id}")
    @ApiOperation("删除未来计划")
    public Result deleteFuture(@PathVariable Long id) {
        log.info("删除未来计划：{}", id);

        futureService.deleteFuture(id);
        return Result.success();
    }

    // 完成未来计划
    @PostMapping("/finish/{id}")
    @ApiOperation("完成未来计划")
    public Result finishFuture(@PathVariable Long id) {
        log.info("完成未来计划：{}", id);

        futureService.finishFuture(id);
        return Result.success();
    }

    // 新增或修改未来计划
    @PostMapping("/save")
    @ApiOperation("新增或修改未来计划")
    public Result save(@RequestBody FutureSaveDTO futureSaveDTO) {
        log.info("新增或修改未来计划：{}", futureSaveDTO);

        futureService.save(futureSaveDTO);
        return Result.success();
    }

    @PostMapping("/test")
    public Result test(@RequestBody TestObj testObj) {
        log.info("testObj: {}", testObj);
        return Result.success();
    }

}

class TestObj {
    private String name;
    private Integer age;
}
