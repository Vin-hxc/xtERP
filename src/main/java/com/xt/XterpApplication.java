package com.xt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.xt.mapper"})
public class XterpApplication {

    public static void main(String[] args) {
        SpringApplication.run(XterpApplication.class, args);

    }

}
