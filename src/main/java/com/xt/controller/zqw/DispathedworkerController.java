package com.xt.controller.zqw;

import com.xt.service.zqw.ProductionplanServiceI;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class DispathedworkerController {
    @Resource
    private ProductionplanServiceI productionplanServiceI;

}
