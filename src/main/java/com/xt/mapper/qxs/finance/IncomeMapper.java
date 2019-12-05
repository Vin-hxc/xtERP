package com.xt.mapper.qxs.finance;

import com.xt.entity.qxs.finance.Income;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 财政收入明细数据操作
 */
public interface IncomeMapper {

    /**
     * 查询所有未删除的财政收入记录
     * @return
     */
    @Select("select * from income where deleteFlag!=1 order by date_recorded desc")
    List<Income> queryNotDeleteIncome();

    /**
     * 查询所有删除的财政收入记录
     * @return
     */
    @Select("select * from income where deleteFlag=1 order by date_recorded desc")
    List<Income> queryDeleteIncome();

    /**
     * 查询所有记录 包括删除的数据
     * @return
     */
    @Select("select * from income order by date_recorded desc")
    List<Income> queryAllIncome();

    /**
     * 根据id获取当前记录
     * @param incomeId
     * @return
     */
    @Select("select * from income where incomeId=#{incomeId} and deleteFlag!=`1")
    Income  getOneIncome(Integer incomeId);

    /**
     * 是否确认收款
     * @param state 0：未收款；1：已收款 审批字段
     * @param id
     * @return
     */
    @Update("update income set confirm_receipt=#{state} where incomeId=#{id}")
    boolean confirmation(Integer state,Integer id);

    /**
     * 修改收入记录
     * @param income
     * @return
     */
    @Update("update income set payable=#{payable},paymentMethod=#{paymentMethod}," +
            "actual_payment=#{actual_payment},balance_payment=#{balance_payment}," +
            "date_recorded=#{date_recorded},remark=#{remark} where incomeId=#{incomeId}")
    boolean updateIncome(Income income);

    /**
     * 清算尾款
     * @param balance_payment
     * @param id
     * @return
     */
    @Update("update income set balance_payment=#{balance_payment} where incomeId=#{id}")
    boolean liquidationIncome(Double balance_payment,Integer id);

    /**
     * 标记删除
     * @param deleteFlag 1：删除; 0：不删除
     * @param id 条件
     * @return
     */
    @Update("update income set deleteFlag=#{deleteFlag} where incomeId=#{id}")
    boolean deleteIncome(Integer deleteFlag,Integer id);

    /**
     * 结算总收入
     * @return
     */
    @Select("select * from income where deleteFlag !=1 and confirm_receipt =1 ")
    Double sumIncome();
}
