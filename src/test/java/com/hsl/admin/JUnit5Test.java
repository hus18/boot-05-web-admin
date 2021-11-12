package com.hsl.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class JUnit5Test {

    @Test
    void testSimpleAssertions(){
        int cal = cal(3,3);
        Assertions.assertEquals(5,cal,"业务逻辑计算失败");
    }
    int cal(int i,int j){
        return i+j;
    }
    @DisplayName("测试displayname注解")
    @Test
    void disPlayName(){
        log.info("1");
    }

}
