package com.xt.entity.qxs.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单据子表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepotItem {
    private Integer id;//主键
    private Depothead header;//单据主表id
    private Integer materialId;//材料id
    private String mUnit;//计量单位
    private Double basicNumber;//基础数量
    private Double unitPrice;//单价
    private Double allPrice;//总金额
    private String remark;//描述
    private String img;//样品图
    private Depot depot;//仓库id
    private String mType;//商品类型
    private String deleteFlag;//标记删除
}
