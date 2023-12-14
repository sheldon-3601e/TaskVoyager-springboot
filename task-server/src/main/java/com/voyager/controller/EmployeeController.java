package com.voyager.controller;

import com.voyager.dto.EmployeeLoginDTO;
import com.voyager.entity.User;
import com.voyager.result.Result;
import com.voyager.service.EmployeeService;
import com.voyager.vo.EmployeeLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName employeeController
 * @Author 26483
 * @Date 2023/12/13 16:13
 * @Version 1.0
 * @Description 用户相关接口
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户相关接口")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("用户登录：{}", employeeLoginDTO);

        User user = employeeService.login(employeeLoginDTO);

        // TODO 登录成功后，生成jwt令牌

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .token("202108212021082120210821")
                .build();
        return Result.success(employeeLoginVO);
    }

}
