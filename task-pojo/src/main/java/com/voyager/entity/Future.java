package com.voyager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
    private String status;

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
    private String black02;

    /**
     *
     */
    private Long userId;

    /**
     *
     */
    private Long detailId;

    /**
     *
     */
    private Long tagId;

}