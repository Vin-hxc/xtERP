package com.xt.entity.vin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;//产品主键
    private String product_name;//产品名称
    private String product_model;//产品型号
    private int product_type;//产品类别
    private String product_unit;//产品单位
    private int product_stock;//产品库存
    private Double retail_price;//零售价
    private Double min_price;//最低售价
    private Double cost_price;//预计成本价格
    private Double trade_price;//销售价格
    private int product_state;//产品状态
    private String serial_number;//产品序列号
    private String deleteFlag;//删除标记（0==未删除,1==删除)
}
