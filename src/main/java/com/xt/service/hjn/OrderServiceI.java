package com.xt.service.hjn;

import com.xt.entity.hjn.Orders;


import java.util.Date;
import java.util.List;

/**
 * @program: xterp
 * @description: OrderServiceI
 * @author: hjn
 * @create: 2019-12-16 08:56
 **/
public interface OrderServiceI {
    /**
     * 查询所有采购订单
     * @return
     */
    List<Orders> findOrders(String orderid, Date createtime);

    /**
     * 添加采购订单
     * @return
     */
    int addOrders(Orders order);

    /**
     * 审核采购
     * @return
     */
    int updateState(int orderstate,int id);

    /**
     * 修改采购订单
     * @param id
     * @param supplierid
     * @param purchaserid
     * @param rebate
     * @param amount_paid
     * @return
     */
    int updateOrders(int id,int supplierid,int purchaserid,int rebate,int amount_paid);





}
