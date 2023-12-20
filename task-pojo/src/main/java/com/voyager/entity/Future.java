package com.voyager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * @TableName future
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Future implements Serializable {
    /**
     *
     */

    private Long id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer status;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private String blank01;

    /**
     *
     */
    private LocalDate createTime;

    /**
     *
     */
    private Long userId;

    /**
     *
     */
    private LocalDate deadline;

    /**
     *
     */
    private Long tagId;

}