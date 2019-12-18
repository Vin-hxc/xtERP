package com.xt.controller.zqw;

import com.xt.entity.zqw.Number;
import com.xt.entity.zqw.Picking;
import com.xt.entity.zqw.Productionplan;
import com.xt.service.zqw.NumberServiceI;
import com.xt.service.zqw.ProductionplanServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class NumberContrller {
    @Resource
    private NumberServiceI numberServiceI;

    /**
     * 添加领料
     * @param numberzb
     * @param numbercpu
     * @param numbernc
     * @param numberxk
     * @param numberyp
     * @param numbergtyp
     * @param pickid
     * @return
     */
    @RequestMapping("insernum")
    public String insernum(String numberzb,String numbercpu,String numbernc,String numberxk,String numberyp,String numbergtyp,int pickid,int productionid){
     Number number = new Number(0,numberzb,numbercpu,numbernc,numberxk,numberyp,numbergtyp,pickid);
     Date t = new Date();
     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     String format = df.format(t);
     Picking picking = new Picking(0,pickid,t,0,0,productionid);
     Boolean aBoolean = numberServiceI.inserNum(number,picking);
     return "redirect:/selepml";
    }
}
