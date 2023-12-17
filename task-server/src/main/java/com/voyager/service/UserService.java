package com.voyager.service;

import com.voyager.dto.UserLoginDTO;
import com.voyager.entity.User;

/**
* @author 26483
* @description 针对表【employee】的数据库操作Service
* @createDate 2023-12-13 16:25:33
*/
public interface UserService {

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);
}
