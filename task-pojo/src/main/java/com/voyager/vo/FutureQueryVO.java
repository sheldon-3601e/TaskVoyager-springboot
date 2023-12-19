package com.voyager.vo;

import com.voyager.entity.Detail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName FutureQueryVO
 * @Author 26483
 * @Date 2023/12/17 19:15
 * @Version 1.0
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FutureQueryVO {

    private Long id;
    private String name;
    private String status;
    private String description;
    private Long tagId;
    private LocalDate deadline;
    private LocalDate createTime;
    private List<Detail> detailList;

}
