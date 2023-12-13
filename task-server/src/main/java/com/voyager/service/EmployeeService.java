package com.voyager.service;

import com.voyager.dto.EmployeeLoginDTO;
import com.voyager.entity.Employee;

/**
* @author 26483
* @description 针对表【employee】的数据库操作Service
* @createDate 2023-12-13 16:25:33
*/
public interface EmployeeService {

    /**
     * 用户登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);
}
