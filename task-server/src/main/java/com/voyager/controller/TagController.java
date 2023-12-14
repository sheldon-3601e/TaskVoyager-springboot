package com.voyager.controller;

import com.voyager.entity.Tag;
import com.voyager.result.Result;
import com.voyager.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
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
    @ApiOperation("根据用户id查询标签")
    public Result<List<Tag>> queryTag() {
        log.info("查询标签");
        List<Tag> tagList = tagService.queryByUserId();

        return Result.success(tagList);
    }

}
