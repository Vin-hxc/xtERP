package com.xt.entity.hxc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_type {
    private int id;//主键
    private String type_name;//产品类别名
    private String remake;//产品状态
    private String deleteFlag;//删除标记（0==未删除,1==删除)
}
