package com.xt.controller;

import com.xt.mapper.vin.ProductMapper;
import com.xt.service.vin.ProductServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ProductController {
    @Resource
    private ProductServiceI productServiceI;

    @RequestMapping("/getAllProduct")
    public String getAllProduct(){

        return  "product";
    }
}
