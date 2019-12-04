package com.xt.entity.qxs.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单据子表
 */
@NoArgsConstructor
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
    private String delete_Flag;//标记删除

    public DepotItem(Integer id, Depothead header, Integer materialId,
                     String mUnit, Double basicNumber, Double unitPrice,
                     String remark, String img, Depot depot,
                     String mType, String deleteFlag) {
        this.id = id;
        this.header = header;
        this.materialId = materialId;
        this.mUnit = mUnit;
        this.basicNumber = basicNumber;
        this.unitPrice = unitPrice;
        //计算总金额
        this.allPrice = this.basicNumber*this.unitPrice;
        this.remark = remark;
        this.img = img;
        this.depot = depot;
        this.mType = mType;
        this.delete_Flag = deleteFlag;
    }
}
