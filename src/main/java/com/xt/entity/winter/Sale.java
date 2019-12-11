package com.xt.entity.winter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Winter
 * @Date 2019/12/10 10:44
 * 销售实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale implements Serializable {
    private Integer id;//编号
    private Integer userId;//用户编号
    private Integer clientId;//客户编号
    private Integer productId;//产品编号
    private Integer depotId;//仓库编号
    private Integer state;//状态
    private Integer deleteFlag;//删除标记
}
