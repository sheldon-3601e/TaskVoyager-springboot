package com.voyager.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName TodayQueryVO
 * @Author 26483
 * @Date 2023/12/17 17:45
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 用户id
    private Long userId;

    // 标签id
    private Long tagId;

    // 内容
    private String name;

    // 优先级，1：low，2：Medium，3：high
    private Integer priority;

    // 状态，1：未完成，2：已完成 3.计时中
    private Integer status;

    // 创建时间
    private LocalDateTime createTime;

}
