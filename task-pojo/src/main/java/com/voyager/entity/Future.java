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

    private byte[] id;

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
    private byte[] empId;

    /**
     *
     */
    private byte[] detailId;

    /**
     *
     */
    private byte[] tagId;

}