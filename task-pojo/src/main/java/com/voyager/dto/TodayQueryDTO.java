package com.voyager.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName TodayQueryDTO
 * @Author 26483
 * @Date 2023/12/14 17:20
 * @Version 1.0
 * @Description TODO
 */
@Data
@ApiModel(value = "查询今日待办时传递的数据模型")
public class TodayQueryDTO {

    private Long userId;

    private LocalDate localDate;

    private Integer status;
}
