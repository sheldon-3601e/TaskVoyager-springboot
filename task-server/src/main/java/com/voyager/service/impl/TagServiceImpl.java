package com.voyager.service.impl;


import com.voyager.entity.Tag;
import com.voyager.mapper.TagMapper;
import com.voyager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 26483
* @description 针对表【tag】的数据库操作Service实现
* @createDate 2023-12-13 16:26:13
*/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> queryByUserId() {

        // TODO 获取当前登录用户的id
        Long userId = 1L;
        return tagMapper.queryByUserId(userId);
    }
}




