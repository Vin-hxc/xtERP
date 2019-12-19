package com.xt;

import com.xt.service.zqw.NumberServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class XterpApplicationTests {
    @Autowired
    private NumberServiceI numberServiceI;

    @Test
    void contextLoads() {
        System.out.println(new Date());
    }



}