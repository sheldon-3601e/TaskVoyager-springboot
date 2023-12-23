package com.voyager.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TagDataVO
 * @Author 26483
 * @Date 2023/12/23 10:14
 * @Version 1.0
 * @Description 标签时间统计
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagDataVO {

    private String name;

    private Integer value;

}
