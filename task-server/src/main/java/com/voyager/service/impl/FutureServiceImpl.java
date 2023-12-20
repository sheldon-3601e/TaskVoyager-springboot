package com.voyager.service.impl;


import com.voyager.constant.StatusConstant;
import com.voyager.dto.FutureSaveDTO;
import com.voyager.entity.Future;
import com.voyager.mapper.FutureMapper;
import com.voyager.service.FutureService;
import com.voyager.vo.FutureQueryVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
* @author 26483
* @description 针对表【future】的数据库操作Service实现
* @createDate 2023-12-13 16:26:13
*/
@Service
public class FutureServiceImpl implements FutureService {

    @Autowired
    private FutureMapper futureMapper;

    @Override
    public List<FutureQueryVO> queryFuture() {

        // TODO 获取当前登录用户的id
        Long userId = 1L;
        List<FutureQueryVO> list = futureMapper.queryFuture(userId);

        return list;
    }

    @Override
    public void deleteFuture(Long id) {

        // TODO 获取当前登录用户的id
        Long userId = 1L;

        futureMapper.deleteFuture(id, userId);

    }

    @Override
    public void finishFuture(Long id) {

        // TODO 获取当前登录用户的id
        Long userId = 1L;

        futureMapper.finishFuture(id, userId, StatusConstant.COMPLETED);

    }

    @Override
    public void save(FutureSaveDTO futureSaveDTO) {
        // 进行判断
        // TODO 获取当前登录用户的id
        Long userId = 1L;
        Long id = futureSaveDTO.getId();

        // 如果id为空，说明是新增
        if (id == null) {
            id = System.currentTimeMillis();
            // 先添加未来计划
            Future future = new Future();
            try {
                BeanUtils.copyProperties(future, futureSaveDTO);
                future.setId(id);
                future.setUserId(userId);
                future.setCreateTime(LocalDate.now());
                futureMapper.insert(future);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // 在添加细节步骤
        }

        // 如果id不为空，说明是修改
        else {
            // 先修改未来计划

            // 删除细节步骤

            // 在添加细节步骤
        }
    }
}




