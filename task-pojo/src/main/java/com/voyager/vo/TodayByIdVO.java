package com.voyager.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName TodayByIdVO
 * @Author 26483
 * @Date 2023/12/14 22:31
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayByIdVO implements Serializable {

    private Long id;

    private String name;

    private Long tagId;

    private Integer priority;

}
