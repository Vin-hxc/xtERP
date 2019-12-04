package com.xt.entity.qxs.warehouse;

import com.xt.entity.qxs.finance.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 单据主表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Depothead {
    private Integer id;//单据id
    private String type;//类型：出库/入库
    private String number;//票据号
    private String operPersonName;//操作人姓名
    private Date createTime;//创建时间
    private Date operTime;//出入库时间
    private Integer organId;//供应商/客户 id
    private Integer handsPersonId;//经手人id：销售/采购
    private Account account;//外键 付款账号
    private Double changeAmount;//变动金额 付款/收款
    private Double totalPrice;//合计金额
    private String payType;//付款方式
    private String remark;//描述
    private Integer accountDay;//存储天数
    private Integer status;//单据状态 1 已审核 0未审核 2：不通过 默认 0 其他数值为待审核
    private String delete_Flag;//标记删除 1 删除 0 未删除 默认 0
}
