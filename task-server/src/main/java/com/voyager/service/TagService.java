package com.voyager.service;


import com.voyager.dto.TagDTO;
import com.voyager.vo.TagQueryVo;

import java.util.List;

/**
* @author 26483
* @description 针对表【tag】的数据库操作Service
* @createDate 2023-12-13 16:26:13
*/
public interface TagService {

    /**
     * 根据用户id查询标签
     *
     * @return
     */
    List<TagQueryVo> queryByUserId();

    /**
     * 根据id修改标签
     * @param tagDTO
     */
    void updateTag(TagDTO tagDTO);

    /**
     * 添加标签
     * @param name
     */
    void saveTag(String name);

    /**
     * 删除标签
     * @param id
     */
    void deleteTag(Long id);
}
