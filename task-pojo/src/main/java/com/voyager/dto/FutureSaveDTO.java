package com.voyager.dto;

import com.voyager.entity.Detail;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName FutureSaveDTO
 * @Author 26483
 * @Date 2023/12/21 1:54
 * @Version 1.0
 * @Description TODO
 */
@Data
@ApiModel(value = "修改或保存时传递的数据模型")
public class FutureSaveDTO {

//    private Long id;
    private String name;
    private String description;
    private Long tagId;  // Assuming tagId can be null
    private LocalDate deadline;  // Using Optional for nullable LocalDate
//    private List<Detail> detailList;

}
