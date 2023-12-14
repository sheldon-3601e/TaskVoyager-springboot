package com.voyager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;

/**
 * @ClassName TodayAdd
 * @Author 26483
 * @Date 2023/12/14 14:51
 * @Version 1.0
 * @Description TODO
 */
@Data
@ApiModel(value = "添加今日待办时传递的数据模型")
public class TodayAdd implements Serializable {

    @ApiModelProperty("代办内容")
    private String name;

    @ApiModelProperty("代办标签")
    private Long tagId;

    @ApiModelProperty("代办优先级")
    private Integer priority;
}
