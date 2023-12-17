package com.voyager.service.impl;

import com.voyager.constant.MessageConstant;
import com.voyager.dto.UserLoginDTO;
import com.voyager.entity.User;
import com.voyager.exception.LoginFailedException;
import com.voyager.mapper.UserMapper;
import com.voyager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 26483
 * @description 针对表【employee】的数据库操作Service实现
 * @createDate 2023-12-13 16:25:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserLoginDTO userLoginDTO) {

        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        User user = userMapper.login(username);
        if (user == null) {
            throw new LoginFailedException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        if (!user.getPassword().equals(password)) {
            throw new LoginFailedException(MessageConstant.PASSWORD_ERROR);
        }
        return user;
    }
}




