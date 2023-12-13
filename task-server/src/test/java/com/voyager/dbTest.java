package com.voyager;

import com.voyager.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName com.voyager.dbTest
 * @Author 26483
 * @Date 2023/12/13 16:53
 * @Version 1.0
 * @Description TODO
 */
@SpringBootTest
public class dbTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test() throws Exception {
        System.out.println(employeeMapper.login("admin"));
    }

}
