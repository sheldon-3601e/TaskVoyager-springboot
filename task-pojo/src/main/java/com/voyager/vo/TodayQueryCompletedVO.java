package com.voyager.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName TodayQueryVo
 * @Author 26483
 * @Date 2023/12/14 17:10
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayQueryCompletedVO implements Serializable {

    private Long id;

    private String name;

    private Long tagId;

    private Integer priority;

}
