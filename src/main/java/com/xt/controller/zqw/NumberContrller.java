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
import java.text.ParseException;
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
     * @param
     * @return
     */
    @RequestMapping("insernum")
    public String insernum(int id, Date startTime,Date endTime,int personCharge,String numberzb,String numbercpu,String numbernc,String numberxk,String numberyp,String numbergtyp,int pickingNo) throws ParseException {
     Number number = new Number(0,numberzb,numbercpu,numbernc,numberxk,numberyp,numbergtyp,pickingNo);
     Date t = new Date();
     Picking picking = new Picking();
     picking.setId(0);
     picking.setPickingNo(pickingNo);
     picking.setStartTime(t);
     picking.setProductionAudit(0);
     picking.setDeletePick(0);
     Productionplan productionplan = new Productionplan();
     productionplan.setId(0);
     productionplan.setProductId(id);
     productionplan.setStartTime(startTime);
     productionplan.setEndTime(endTime);
     productionplan.setPersonCharge(personCharge);
     productionplan.setProductionAudit(0);
     productionplan.setDeleteProd(0);
     productionplan.setPickingid(pickingNo);
     Boolean aBoolean = numberServiceI.inserNum(number,picking,productionplan);
     System.out.println(aBoolean);
     return "redirect:/pdsele";
    }
}
