package com.xt.controller.qxs;

import com.xt.entity.qxs.finance.Expenditure;
import com.xt.entity.qxs.finance.FinancialSettlement;
import com.xt.entity.qxs.finance.Income;
import com.xt.service.qxs.finance.ExpenditureServiceI;
import com.xt.service.qxs.finance.FinancialSettlementServiceI;
import com.xt.service.qxs.finance.IncomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 查询所有汇总记录
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
}
