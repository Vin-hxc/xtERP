package com.xt.controller.zqw;


import com.xt.entity.vin.Product_model;
import com.xt.entity.zqw.Picking;
import com.xt.entity.zqw.Productionplan;
import com.xt.entity.zqw.Userinfo;
import com.xt.service.zqw.ProductionplanServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProductionplanContrller {
    @Resource
    private ProductionplanServiceI productionplanServiceI;

    /**
     * 查询所有生产计划
     * @param request
     * @return
     */
    @RequestMapping("pdsele")
    public String pdsele(HttpServletRequest request){
        List<HashMap> list = productionplanServiceI.seleProuct();
        request.setAttribute("pdsele",list);
        System.out.println(list);
        return "zqw/seleProuct";
    }
    @RequestMapping("aaa")
    public String aaa(){
        return "zqw/index";
    }
    /**
     * 根据申请表查询产品表
     * @param request
     * @return
     */
    @RequestMapping("dgselepd")
   public String dgselepd(HttpServletRequest request){
        List<HashMap> list = productionplanServiceI.dgselepro();
        List<Userinfo> seleuser = productionplanServiceI.seleuser();
        request.setAttribute("dgselepd",list);
        request.setAttribute("seleuserf",seleuser);
        System.out.println(list);
        return "zqw/index";
   }

    /**
     * 查询产品信息
     * @param request
     * @return
     */
   @RequestMapping("selepml")
    public String selepml(HttpServletRequest request){
       List<HashMap> selepm = productionplanServiceI.selepm();
       request.setAttribute("selepml",selepm);
       System.out.println(selepm);
       return "zqw/selepicking";
    }
    /**
     * 添加领料信息
     * @return
     */
   @RequestMapping("inserpick")
   public String inserpick(int pickingNo, int productionid,HttpServletResponse response) throws ParseException {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String a="2019-12-1";
       Date parse = sdf.parse(a);
       Picking picking = new Picking(0,pickingNo,"0",parse,0,0,productionid);
       boolean inserpick = productionplanServiceI.inserpick(picking);
       System.out.println(inserpick);
       return "redirect:/dgselepd";
   }

    /**
     * 添加生产计划
     * @param productId
     * @param startTime
     * @param endTime
     * @param personCharge
     * @param prquantity
     * @return
     */
   @RequestMapping("inserPro")
    public String inserPro( int productId, String startTime,String endTime,int personCharge,int prquantity,HttpServletRequest request) throws ParseException {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date1 = sdf.parse(startTime);
       Date date2 = sdf.parse(endTime);
       Productionplan productionplan = new Productionplan(0,productId,date1,date2,personCharge,0,0,prquantity);
       boolean b = productionplanServiceI.inserProuct(productionplan);
       System.out.println(b);
       return "redirect:/pdsele";
    }
}
