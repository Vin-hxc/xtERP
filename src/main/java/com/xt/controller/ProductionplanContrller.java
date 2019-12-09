package com.xt.controller;


import com.xt.service.zqw.ProductionplanServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProductionplanContrller {
    @Resource
    private ProductionplanServiceI productionplanServiceI;

    @RequestMapping("pdsele")
    public String pdsele(HttpServletRequest request){
        List<HashMap> list = productionplanServiceI.seleProuct();
        request.setAttribute("pdsele",list);
        System.out.println(list);
        return "zqw/seleProuct";
    }
    @RequestMapping("aaa")
    public String aa(){
        System.out.println("1");
        return "zqw/index";
    }
}
