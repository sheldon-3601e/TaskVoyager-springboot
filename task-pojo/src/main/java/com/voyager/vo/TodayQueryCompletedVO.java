package com.voyager.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName TodayUncompletedVO
 * @Author 26483
 * @Date 2023/12/14 19:59
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

}
