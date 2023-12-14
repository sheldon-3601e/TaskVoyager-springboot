package com.voyager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 
 * @TableName detail
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Detail implements Serializable {
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
    private Integer status;

    /**
     * 
     */
    private byte[] empId;

    /**
     * 
     */
    private byte[] futureId;



}