package com.voyager.service;


import com.voyager.entity.Tag;

import java.util.List;

/**
* @author 26483
* @description 针对表【tag】的数据库操作Service
* @createDate 2023-12-13 16:26:13
*/
public interface TagService {

    /**
     * 根据用户id查询标签
     * @return
     */
    List<Tag> queryByUserId();

}
