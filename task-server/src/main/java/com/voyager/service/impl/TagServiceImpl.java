package com.voyager.service.impl;


import com.voyager.constant.MessageConstant;
import com.voyager.dto.TagDTO;
import com.voyager.entity.Tag;
import com.voyager.mapper.TagMapper;
import com.voyager.service.TagService;
import com.voyager.utils.IdUtil;
import com.voyager.vo.TagQueryVo;
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
    public List<TagQueryVo> queryByUserId() {

        // TODO 获取当前登录用户的id
        Long userId = 1L;

        return tagMapper.queryByUserId(userId);
    }

    @Override
    public void updateTag(TagDTO tagDTO) {

        // 先查询该标签是否在存在
        Tag tag = tagMapper.selectById(tagDTO.getId());
        if (tag == null) {
            // 如果存在，就直接返回
            throw new RuntimeException(MessageConstant.TAG_NOT_EXIST);
        }
        // 如果不存在，再修改
        tagMapper.updateTag(tagDTO);

    }

    @Override
    public void saveTag(String name) {

        // 先查询该标签是否在存在
        Tag tag = tagMapper.selectByName(name);
        if (tag != null) {
            // 如果存在，就直接返回
            throw new RuntimeException(MessageConstant.TAG_ALREADY_EXIST);
        }
        Long id = IdUtil.getId();
        // TODO 获取当前登录用户的id
        Long userId = 1L;

        tag = Tag.builder()
                .id(id)
                .userId(userId)
                .name(name)
                .build();
        // 如果不存在，再添加
        tagMapper.saveTag(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }
}




