package com.xt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用来进行访问静态页面的Controller
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String test(){
        return "user/login";
    }

    @RequestMapping("err")
    public String error(){
        System.out.println("当前访问Url:err");
        return "error";
    }

    @RequestMapping("test")
    public String test1(){
        System.out.println("当前访问路径：test");
        return "test";
    }
}
