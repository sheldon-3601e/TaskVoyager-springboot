package com.voyager;

import com.voyager.entity.TodayTime;
import com.voyager.mapper.TodayTimeMapper;
import com.voyager.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.Temporal;

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
    @Autowired
    private TodayTimeMapper todayTimeMapper;

    @Test
    public void test() throws Exception {
        System.out.println(userMapper.login("admin"));
    }

    @Test
    public void test02() {
        LocalDate today = LocalDate.now();

        System.out.println("今天的日期是: " + today);
    }

    @Test
    public void test03() {
        LocalTime stopTime = LocalTime.now();

        // 保存开始时间
        TodayTime todayTime = todayTimeMapper.getById(101L);

        System.out.println(stopTime);
        System.out.println(todayTime.getStartTime());
        Timestamp timestamp = (Timestamp) todayTime.getStartTime();

        // 将时间戳转换为 java.time.LocalDateTime（如果需要）
        java.time.LocalDateTime localDateTime = timestamp.toLocalDateTime();

//        long hours = Duration.between((Temporal) todayTime.getStartTime(), stopTime).toHours();
//        System.out.println(hours);
    }

}
