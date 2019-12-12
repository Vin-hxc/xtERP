package com.xt.controller.qxs;

import com.xt.entity.qxs.finance.Expenditure;
import com.xt.entity.qxs.finance.FinancialSettlement;
import com.xt.entity.qxs.finance.Income;
import com.xt.service.qxs.finance.ExpenditureServiceI;
import com.xt.service.qxs.finance.FinancialSettlementServiceI;
import com.xt.service.qxs.finance.IncomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 财政试图层
 */
@Controller
@RequestMapping("finance/")
public class FinanceController {

    @Autowired
    private FinancialSettlementServiceI financialSettlementServiceI;
    @Autowired
    private ExpenditureServiceI expenditureServiceI;
    @Autowired
    private IncomeServiceI incomeServiceI;

    @RequestMapping("pageFinance")
    public String pageFinance(){
        return "qxs/finance/financeMain";
    }

    /**
     * 查询所有汇总记录,图形报表数据绑定
     * @return
     */
    @RequestMapping("queryNotDeleteFs")
    @ResponseBody
    public List queryNotDeleteFs(){
        List<FinancialSettlement> financialSettlements = financialSettlementServiceI.queryNotDeleteFs();
        if(financialSettlements.size()>0){
            System.out.println(financialSettlements.size()>0);
            for (FinancialSettlement financialSettlement : financialSettlements) {
                System.out.println(financialSettlement);
            }
        }
        return financialSettlements;
    }

    /**
     * 查询所有未删除的支出与收入记录
     * @return
     */
    @ResponseBody
    @RequestMapping("queryNotDeleteFinance")
    public Map queryNotDeleteFinance(){
        //查询支出
        List<Expenditure> expenditures = expenditureServiceI.queryNotExpenditure();
        //查询收入
        List<Income> incomes = incomeServiceI.queryNotDeleteIncome();
        HashMap<Integer, List> map = new HashMap<Integer, List>();
        map.put(1,expenditures);
        map.put(2,incomes);
        return map;
    }

    /**
     * 查询汇总详情，进行页面跳转
     * @return
     */
    @RequestMapping("pageDetailsFs")
    public String pageDetailsFs(Model model){
        System.out.println("url:pageDetailsFs");
        List<FinancialSettlement> fs = financialSettlementServiceI.queryAllFinancialSettlement();
        model.addAttribute("fsList",fs);
        return "qxs/finance/FinancialSettlement";
    }

    /**
     * 标记删除 汇总数据
     * @return
     */
    @RequestMapping("deleteFlagFs")
    @ResponseBody
    public boolean deleteFlagFs(Integer flag,Integer id){
        System.err.println(id);
        return financialSettlementServiceI.deleteFinancialSettlement(flag,id);
    }

    /**
     *  跳转值财务详情页面
     * @return
     */
    @RequestMapping("pageFinanceDetails")
    public String pageFinanceDetails(Model model){
        //查询所有支出记录
        List<Expenditure> expenditures = expenditureServiceI.queryAllExpenditure();
        //查询所有收入记录
        List<Income> incomes = incomeServiceI.queryAllIncome();
        model.addAttribute("expendList",expenditures);
        model.addAttribute("incomeList",incomes);
        return "qxs/finance/financeDetails";
    }

    /**
     * 是否确定收款
     * @param confirm_receipt 审批字段
     * @param id
     * @param type 判断是收款或付款
     * @return
     */
    @RequestMapping("affirm")
    @ResponseBody
    public boolean affirm(Integer confirm_receipt,Integer id,String type){
        System.err.println(confirm_receipt+"=="+id+"=="+type);
        if("支出".equals(type)){
            return expenditureServiceI.confirmation(confirm_receipt, id);
        }else if("收入".equals(type)){
            return incomeServiceI.confirmation(confirm_receipt,id);
        }
        return false;
    }

    /**
     * 收支记录删除
     * @param flag 标记删除字段
     * @param id 条件
     * @param type 判断 收入/支出
     * @return
     */
    @RequestMapping("expurgate")
    @ResponseBody
    public boolean expurgate(Integer flag,Integer id,String type){
        System.err.println(flag+"=="+id+"=="+type);
        if("支出".equals(type)){
            return expenditureServiceI.deleteExpenditure(flag,id);
        }else if("收入".equals(type)){
            return incomeServiceI.deleteIncome(flag,id);
        }
        return false;
    }

    /**
     * 查询整个项目的支出/收入
     * @param type 判断   支出 / 收入
     * @return
     */
    public String addReady(Integer type){

        return "";
    }

}
