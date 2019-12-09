package com.xt.entity.qxs.finance;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 财政收入明细实体
 */

@NoArgsConstructor
@Data
public class Income {

    private Integer incomeId;//收入编号
    private Integer clientId;//客户编号
    private Double payable;//应付金额
    private String paymentMethod;//付款类型：记账；全款；定金；
    private Double actual_payment;//实付金额
    private Double balance_payment;//尾款
    private Date date_recorded;//入账时间
    private Integer confirm_receipt;//确认收款；0：未收款；1：已收款；审批字段
    private Integer principal;//负责人；用户id
    private String remark;//描述
    private Integer stateClose;// 结算状态 0 未结算 1 已结算
    private Integer deleteFlag;//标记删除

    public Income(Integer incomeId, Integer clientId,
                  Double payable, String paymentMethod,
                  Double actual_payment, Date date_recorded, Integer confirm_receipt,
                  Integer principal, String remark, Integer stateClose, Integer deleteFlag) {
        this.incomeId = incomeId;
        this.clientId = clientId;
        this.payable = payable;
        this.paymentMethod = paymentMethod;
        this.actual_payment = actual_payment;
        // 计算尾款
        if("全款".equals(this.paymentMethod)){
            this.balance_payment = 0.00;
        }else{
            this.balance_payment = this.payable-this.actual_payment;
        }
        this.date_recorded = date_recorded;
        this.confirm_receipt = confirm_receipt;
        this.principal = principal;
        this.remark = remark;
        this.stateClose = stateClose;
        this.deleteFlag = deleteFlag;
    }
}
