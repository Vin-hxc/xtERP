package com.xt.controller.winter;

import com.xt.entity.qxs.warehouse.DepotItem;
import com.xt.entity.qxs.warehouse.Depothead;
import com.xt.entity.winter.Sale;
import com.xt.service.winter.SaleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Winter
 * @Date 2019/12/17 10:44
 */
@Controller
public class SaleController {
    @Autowired
    private SaleServiceI saleService;

    /**
     * 查询所有销售数据
     * @return
     */
    @RequestMapping("/allSale")
    public String getAllSale(Model model){
        List<HashMap> allNoDeleteSale = saleService.getAllNoDeleteSale();
        model.addAttribute("sale",allNoDeleteSale);
        for (HashMap pro : allNoDeleteSale){
            System.out.println(pro);
        }
        return "winter/sale/allSale";
    }

    /**
     * @param sale
     * @param depothead
     * @param depotItem
     * @return
     * @throws ParseException
     */
    @RequestMapping("/addSale")
    public String saveSaleAndDepotHead(Sale sale, Depothead depothead, DepotItem depotItem) throws ParseException {

        return null;
    }
}
