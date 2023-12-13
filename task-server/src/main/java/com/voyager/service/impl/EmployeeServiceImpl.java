package com.voyager.service.impl;

import com.voyager.constant.MessageConstant;
import com.voyager.dto.EmployeeLoginDTO;
import com.voyager.entity.Employee;
import com.voyager.exception.LoginFailedException;
import com.voyager.mapper.EmployeeMapper;
import com.voyager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 26483
 * @description 针对表【employee】的数据库操作Service实现
 * @createDate 2023-12-13 16:25:33
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {

        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        Employee employee = employeeMapper.login(username);
        if (employee == null) {
            throw new LoginFailedException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        if (!employee.getPassword().equals(password)) {
            throw new LoginFailedException(MessageConstant.PASSWORD_ERROR);
        }
        return employee;
    }
}




