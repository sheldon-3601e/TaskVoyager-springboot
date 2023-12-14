package com.voyager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName Today
 * @Author 26483
 * @Date 2023/12/14 16:03
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Today implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 用户id
    private Long userId;

    // 标签id
    private Long tagId;

    // 内容
    private String name;

    // 优先级，1：低，2：中，3：高
    private Integer priority;

    // 状态，1：未完成，2：已完成
    private Integer status;

    // 创建时间
    private LocalDateTime createTime;

    // 空白字段
    private String black01;

    private String blank02;



}
