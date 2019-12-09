package com.xt.controller.winter;

import com.xt.entity.winter.Recruit;
import com.xt.service.winter.RecruitServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author Winter
 * @Date 2019/12/6 15:06
 */
@Controller
public class RecruitController {
    @Autowired
    private RecruitServiceI recruitService;
    @RequestMapping("/addRecruit")
    public String saveRecruit(Recruit recruit){
        boolean flag = recruitService.saveRecruit(recruit);
        if (flag){
            return "/getRecruit";
        }else{
            return "false";
        }
    }

    public String updateRecruit(Recruit recruit){
        boolean flag = recruitService.updateRecruit(recruit);
        if (flag){
            return "/getRecruit";
        }else {
            return "false";
        }
    }
}
