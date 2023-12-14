package com.voyager.vo;

import com.voyager.entity.Today;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName TodayQueryVo
 * @Author 26483
 * @Date 2023/12/14 17:10
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "今日代办查询返回的数据格式")
public class TodayQueryVo {

    private List<Today> todayList;

}
