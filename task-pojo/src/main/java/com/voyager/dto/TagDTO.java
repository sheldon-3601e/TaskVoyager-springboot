package com.voyager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TagUpdateDTO
 * @Author 26483
 * @Date 2023/12/17 18:20
 * @Version 1.0
 * @Description TODO
 */
@Data
@ApiModel(value = "修改标签时传递的数据模型")
public class TagDTO {

    @ApiModelProperty("标签")
    private String name;

    @ApiModelProperty("id")
    private Long id;

}
