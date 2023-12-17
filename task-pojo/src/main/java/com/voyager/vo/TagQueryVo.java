package com.voyager.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TagQueryVo
 * @Author 26483
 * @Date 2023/12/17 18:16
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagQueryVo {

    private Long id;
    private String name;
    private Long userId;

}
