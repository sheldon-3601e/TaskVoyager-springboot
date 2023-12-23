package com.voyager.vo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TodayDataVO
 * @Author 26483
 * @Date 2023/12/23 9:42
 * @Version 1.0
 * @Description 总结每日计划的完成情况
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayDataVO {

    private List<String> xAxis;
    private List<Integer> yAxis;
    private List<Integer> unFinishData;
    private List<Integer> finishData;

}
