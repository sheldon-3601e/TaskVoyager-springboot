package com.voyager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName employee
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private Long id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Integer sex;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String blank01;

    /**
     * 
     */
    private String blank02;



}