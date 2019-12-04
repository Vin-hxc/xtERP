package com.xt.mapper.hjn;

import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @program: xterp
 * @description: OrderMapper
 * @author: hjn
 * @create: 2019-12-03 16:55
 **/
public interface OrderMapper {
    /**
     * 查询所有采购订单
     * @return
     */
    @Select("select * from Order")
    List<Order> queryAllDepot();

    /**
     * 新增采购订单
     * @return
     */
    @Select("select * from depot where !=1delete_Flag order by sort desc")
    List<Depot> queryAllDepot();

}
