package com.voyager.controller;

import com.voyager.dto.TagDTO;
import com.voyager.result.Result;
import com.voyager.service.TagService;
import com.voyager.vo.TagQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName TagController
 * @Author 26483
 * @Date 2023/12/14 19:02
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/tag")
@Api(tags = "标签相关接口")
@Slf4j
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/query")
    @ApiOperation("查询标签")
    public Result<List<TagQueryVo>> queryTag() {
        log.info("查询标签");
        List<TagQueryVo> tagList = tagService.queryByUserId();

        return Result.success(tagList);
    }

    @GetMapping("/update")
    @ApiOperation("修改标签")
    public Result updateTag(@RequestBody TagDTO tagDTO) {
        log.info("修改标签");

        tagService.updateTag(tagDTO);

        return Result.success();
    }

    @GetMapping("/save")
    @ApiOperation("添加标签")
    public Result saveTag(@RequestParam String name) {
        log.info("添加标签");

        tagService.saveTag(name);

        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public Result deleteTag(@PathVariable Long id) {
        log.info("删除标签");

        tagService.deleteTag(id);

        return Result.success();
    }



}
