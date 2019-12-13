package com.xt.service.qxs.finance.impl;

import com.xt.entity.qxs.finance.FinancialSettlement;
import com.xt.entity.qxs.finance.Income;
import com.xt.mapper.hjn.OrderMapper;
import com.xt.mapper.qxs.finance.FinancialSettlementMapper;
import com.xt.mapper.qxs.finance.IncomeMapper;
import com.xt.mapper.winter.SaleMapper;
import com.xt.service.qxs.finance.IncomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IncomeServiceImpl implements IncomeServiceI {

    @Autowired
    private IncomeMapper incomeMapper;
    @Autowired
    private FinancialSettlementMapper financialSettlementMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SaleMapper saleMapper;

    /**
     * 查询所有未删除的数据
     * @return
     */
    @Override
    public List<Income> queryNotDeleteIncome() {
        return incomeMapper.queryNotDeleteIncome();
    }

    /**
     * 查询所有已删除的数据
     * @return
     */
    @Override
    public List<Income> queryDeleteIncome() {
        return incomeMapper.queryDeleteIncome();
    }

    /**
     * 查询所有收入记录
     * @return
     */
    @Override
    public List<Income> queryAllIncome() {
        return incomeMapper.queryAllIncome();
    }

    /**
     * 根据id获取当前数据
     * @param incomeId
     * @return
     */
    @Override
    public Income getOneIncome(Integer incomeId) {
        return incomeMapper.getOneIncome(incomeId);
    }

    /**
     * 是否确定收款
     * @param state 0：未收款；1：已收款 审批字段
     * @param id
     * @return
     */
    @Override
    public boolean confirmation(Integer state, Integer id) {
        return incomeMapper.confirmation(state,id);
    }

    /**
     * 修改收入记录
     * @param income
     * @return
     */
    @Override
    public boolean updateIncome(Income income) {
        return incomeMapper.updateIncome(income);
    }

    /**
     * 清算尾款
     * @param balance_payment
     * @param id
     * @return
     */
    @Override
    public boolean liquidationIncome(Double balance_payment, Integer id) {
        return incomeMapper.liquidationIncome(balance_payment,id);
    }

    /**
     * 标记删除
     * @param deleteFlag 1：删除; 0：不删除
     * @param id 条件
     * @return
     */
    @Override
    public boolean deleteIncome(Integer deleteFlag, Integer id) {
        return incomeMapper.deleteIncome(deleteFlag,id);
    }

    /**
     * 结算总收入
     * @return
     */
    @Override
    public boolean sumIncome(FinancialSettlement fs) {
        //调用结算方法
        Double income = incomeMapper.sumIncome();
        System.out.println("总收入："+income);
        if(income > 0.00){
            //调用修改结算状态方法
            boolean stateClose = incomeMapper.updateStateClose(1);
            if(stateClose){
                //给FinancialSettlement 对象赋值
                fs.setTotalMoney(income);
                fs.setType(2);
                //调用 财政结算的新增方法
                boolean b = financialSettlementMapper.addFinancialSettlement(fs);
                return b;
            }
        }
        return false;
    }

    /**
     * 新增记录
     * @param income
     * @return
     */
    @Override
    public boolean addIncome(Income income,Integer id) {
        boolean b = saleMapper.updateFinance(id);
        if(b){
            return incomeMapper.addIncome(income);
        }
        return false;
    }

    /**
     * 查询整个项目的支出/收入
     * @return
     */
    @Override
    public Map addReady() {
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        //查询支出
        List<HashMap> orderMap = orderMapper.incurExpense();
        map.put(1,orderMap);
        //查询所有收款
        List<HashMap> saleMap = saleMapper.salesProceeds();
        map.put(2,saleMap);
        return map;
    }
}
