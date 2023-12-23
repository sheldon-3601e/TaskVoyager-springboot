package com.voyager.vo;

import com.voyager.entity.Today;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName TodayHistoryVO
 * @Author 26483
 * @Date 2023/12/23 15:51
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodayHistoryVO {

    private LocalDate localDate;
    private List<Today> todayList;

}
