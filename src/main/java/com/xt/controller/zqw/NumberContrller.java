package com.xt.controller.zqw;

import com.xt.entity.qxs.warehouse.Materials;
import com.xt.entity.zqw.Number;
import com.xt.entity.zqw.Picking;
import com.xt.entity.zqw.Productionplan;
import com.xt.service.zqw.NumberServiceI;
import com.xt.service.zqw.PickingServiceI;
import com.xt.service.zqw.ProductionplanServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
public class NumberContrller {
    @Resource
    private NumberServiceI numberServiceI;

    /**
     * 添加领料
     * @param
     * @return
     */
    @RequestMapping("insernum")
    public String insernum(int id, Date startTime, Date endTime, int personCharge, String[] numbersl, int materialsId, HttpServletRequest request) throws ParseException {
     Date t = new Date();

        List<Materials> materials =numberServiceI.seleMat();
            Productionplan productionplan = new Productionplan(0, id, startTime, endTime, personCharge, 0, 0, materialsId);
            for (int i=0;i<numbersl.length;i++){
                Number number = new Number(0, materialsId, numbersl[i], materialsId);
                Boolean aBoolean = numberServiceI.inserNum(number, new Picking(0, materialsId, t, 0, 0), productionplan);
            }
            return "redirect:/pdsele";
    }
}
