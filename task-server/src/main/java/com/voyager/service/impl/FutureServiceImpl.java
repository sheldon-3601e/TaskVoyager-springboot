package com.voyager.service.impl;


import com.voyager.constant.StatusConstant;
import com.voyager.context.BaseContext;
import com.voyager.dto.FutureSaveDTO;
import com.voyager.entity.Detail;
import com.voyager.entity.Future;
import com.voyager.mapper.DetailMapper;
import com.voyager.mapper.FutureMapper;
import com.voyager.service.FutureService;
import com.voyager.vo.FutureQueryVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.swing.plaf.basic.BasicButtonUI;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @Autowired
    private DetailMapper detailMapper;

    @Override
    public List<FutureQueryVO> queryFuture() {

        Long userId = BaseContext.getCurrentId();
        List<FutureQueryVO> list = futureMapper.queryFuture(userId);

        return list;
    }

    @Override
    public void deleteFuture(Long id) {

        Long userId = BaseContext.getCurrentId();

        futureMapper.deleteFuture(id, userId);

    }

    @Override
    public void finishFuture(Long id) {

        Long userId = BaseContext.getCurrentId();

        futureMapper.finishFuture(id, userId, StatusConstant.COMPLETED);

    }

    @Override
    public void save(FutureSaveDTO futureSaveDTO) {
        // 进行判断
        Long userId = BaseContext.getCurrentId();
        Long futureId = futureSaveDTO.getId();

        // 如果id为空，说明是新增
        if (futureId == null) {
            try {
                // 先添加未来计划
                Future future = new Future();
                BeanUtils.copyProperties(future, futureSaveDTO);
                future.setUserId(userId);
                future.setCreateTime(LocalDate.now());
                future.setStatus(StatusConstant.UNCOMPLETED);
                futureMapper.save(future);
                futureId = future.getId();

                insertDetailBatch(futureSaveDTO, futureId, userId);


            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        // 如果id不为空，说明是修改
        else {
            // 先修改未来计划
            futureMapper.updateById(futureSaveDTO);
            // 删除细节步骤
            detailMapper.deleteByFutureId(futureId);

            // 在添加细节步骤
            insertDetailBatch(futureSaveDTO, futureId, userId);
        }
    }

    private void insertDetailBatch(FutureSaveDTO futureSaveDTO, Long futureId, Long userId) {
        // 在添加细节步骤
        List<Detail> detailList = futureSaveDTO.getDetailList();
        if (detailList == null || detailList.isEmpty()) {
            return;
        }
        // 添加未来计划id
        detailList.forEach(detail -> {
            detail.setFutureId(futureId);
            detail.setUserId(userId);
            detail.setStatus(StatusConstant.UNCOMPLETED);
        });
        // 批量添加
        detailMapper.insertBatch(detailList);
    }
}




