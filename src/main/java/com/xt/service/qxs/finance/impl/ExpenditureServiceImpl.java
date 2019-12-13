package com.xt.service.qxs.finance.impl;

import com.xt.entity.qxs.finance.Expenditure;
import com.xt.entity.qxs.finance.FinancialSettlement;
import com.xt.mapper.hjn.OrderMapper;
import com.xt.mapper.qxs.finance.ExpenditureMapper;
import com.xt.mapper.qxs.finance.FinancialSettlementMapper;
import com.xt.service.qxs.finance.ExpenditureServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExpenditureServiceImpl implements ExpenditureServiceI {

    @Autowired
    private ExpenditureMapper expenditureMapper;
    @Autowired
    private FinancialSettlementMapper financialSettlementMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询所有未删除的数据
     * @return
     */
    @Override
    public List<Expenditure> queryNotExpenditure() {
        return expenditureMapper.queryNotExpenditure();
    }

    /**
     * 查询所有已删除的数据
     * @return
     */
    @Override
    public List<Expenditure> queryDeleteExpenditure() {
        return expenditureMapper.queryDeleteExpenditure();
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Expenditure> queryAllExpenditure() {
        return expenditureMapper.queryAllExpenditure();
    }

    /**
     * 根据id进行查询
     * @param expenditureId
     * @return
     */
    @Override
    public Expenditure getOneExpenditure(Integer expenditureId) {
        return expenditureMapper.getOneExpenditure(expenditureId);
    }

    /**
     * 修改支出记录数据,修改收款账号，清算尾款
     * @param expenditure
     * @return
     */
    @Override
    public boolean updateExpenditure(Expenditure expenditure) {
        return expenditureMapper.updateExpenditure(expenditure);
    }

    /**
     * 修改付款状态
     * @param state 状态；0：未付款；1：已付款；3：取消付款 默认0
     * @param id
     * @return
     */
    @Override
    public boolean confirmation(Integer state, Integer id) {
        return expenditureMapper.confirmation(state,id);
    }

    /**
     * 标记删除
     * @param deleteFlag ；0：未删除；1：已删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteExpenditure(Integer deleteFlag, Integer id) {
        return expenditureMapper.deleteExpenditure(deleteFlag,id);
    }

    /**
     * 新增支出记录
     * @param expenditure
     * @return
     */
    @Override
    public boolean addExpenditure(Expenditure expenditure,Integer id) {
        boolean b = orderMapper.updateFinance(id);
        if(b){
            return expenditureMapper.addExpenditure(expenditure);
        }
        return false;
    }

    /**
     * 对支出进行结算 调用财务总结
     * @return
     */
    @Override
    public boolean sumExpenditure(FinancialSettlement fs) {
        //获取总金额
        Double sumExpenditure = expenditureMapper.sumExpenditure();
        System.out.println("总金额："+sumExpenditure);
        if(sumExpenditure>0.00){
            // 修改结算状态
            boolean stateClose = expenditureMapper.updateStateClose(1);
            if(stateClose){
                fs.setTotal_Money(sumExpenditure);
                fs.setType(1);
                System.out.println("fs对象："+fs);
                return financialSettlementMapper.addFinancialSettlement(fs);
            }
        }

        return false;
    }
}
