package com.xt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class testController {

   /* @ResponseBody*/
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
