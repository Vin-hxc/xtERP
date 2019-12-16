package com.xt.mapper.hjn;

import com.xt.entity.hjn.Cost;
import com.xt.entity.hjn.Detailed;
import com.xt.entity.hjn.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @program: xterp
 * @description: OrderMapper
 * @author: hjn
 * @create: 2019-12-03 16:55
 **/
@Repository
public interface OrderMapper {
    /**
     * 查询所有采购订单
     *
     * @return
     */
    @Select("select * from Orders")
    List<Orders> queryAllOrders();

    /**
     * 条件查询采购订单
     */
    List<Orders> findOrders(String orderid, Date createtime);
    /**
     * 新增采购订单
     *
     * @return
     */
    //@Insert("insert into Orders values(null,#{orderid},#{supplierid},#{purchaserid},#{rebate},#{paytype},#{total},#{amount_paid},#{total_tax},#{orderstate},#{preferential},#{costid})")
    int addOrders(Orders order);



    /**
     * 审核订单
     *
     * @return
     */
    //@Update("update Orders set orderstate=#{orderstate} where id=#{id}")
    int updateState(int id,int orderstate);


    /**
     * 修改采购订单
     *
     * @return
     */
    //@Update("(update Orders set supplierid=#{supplierid},purchaserid=#{purchaserid},rebate=#{rebate},amount_paid=#{amount_paid}   where id=#{id})")
    int updateOrders(int id,int supplierid,int purchaserid,int rebate,int amount_paid);



}