package com.voyager.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName TodayUpdateDTO
 * @Author 26483
 * @Date 2023/12/14 19:27
 * @Version 1.0
 * @Description TODO
 */
@Data
@ApiModel(value = "修改今日待办时传递的数据模型")
public class TodayUpdateDTO {

    private Long id;

    private String name;

    private Integer tagId;

    private Integer priority;

}
