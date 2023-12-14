package com.voyager;

import com.voyager.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

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
    private UserMapper userMapper;

    @Test
    public void test() throws Exception {
        System.out.println(userMapper.login("admin"));
    }

    @Test
    public void test02() {
        LocalDate today = LocalDate.now();

        System.out.println("今天的日期是: " + today);
    }

}
