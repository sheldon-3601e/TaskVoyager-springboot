package com.voyager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 
 * @TableName today_time
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayTime implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     *
     */
    private Date startTime;

    /**
     *
     */
    private Date stopTime;

    /**
     *
     */
    private Date time;

    /**
     *
     */
    private String black01;

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
    private Long tagId;

    /**
     *
     */
    private Long todayId;

}