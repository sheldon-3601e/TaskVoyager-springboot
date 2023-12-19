package com.voyager.service.impl;


import com.voyager.constant.StatusConstant;
import com.voyager.mapper.FutureMapper;
import com.voyager.service.FutureService;
import com.voyager.vo.FutureQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}




