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
    List<Order> queryAllOrder();

    /**
     * 新增采购订单
     * @return
     */
    @Select("insert into order values(null,#{orderid},#{supplierid},#{purchaserid},#{rebate},#{paytype},#{total},#{amount_paid},#{total_tax},#{orderstate},#{preferential},#{costid})")
    List<Order> addOrder(Order order);



}
