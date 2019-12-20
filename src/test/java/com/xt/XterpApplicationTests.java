package com.xt;

import com.xt.entity.hjn.Orders;
import com.xt.mapper.hjn.OrderMapper;
import com.xt.service.zqw.NumberServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class XterpApplicationTests {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
        /*int i = (int) (Math.random()*10000);
        System.out.println(i);*/
        Orders orders = orderMapper.queryID(966);
        System.out.println(orders);
    }



}