package com.hsl.admin;

import com.hsl.admin.bean.User;
import com.hsl.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);

        log.info("记录总数：{}", aLong);
    }

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户信息:{}",user);
    }

}
