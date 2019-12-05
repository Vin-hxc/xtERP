package com.xt.controller;


import com.xt.service.zqw.ProductionplanServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class ProductionplanContrller {
    @Resource
    private ProductionplanServiceI productionplanServiceI;

    @RequestMapping("pdsele")
    public String pdsele(HttpServletRequest request){
        HashMap hashMap = productionplanServiceI.seleProuct();
        request.setAttribute("pdsele",hashMap);
        System.out.println(hashMap);
        return "zqw/seleProuct";
    }
    @RequestMapping("aaa")
    public String aa(){
        System.out.println("1");
        return "zqw/seleProuct";
    }
}
