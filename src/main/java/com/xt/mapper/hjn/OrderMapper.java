package com.xt.mapper.hjn;

import com.xt.entity.hjn.Cost;
import com.xt.entity.hjn.Detailed;
import com.xt.entity.hjn.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.core.annotation.Order;

import java.util.Date;
import java.util.HashMap;
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
     *
     * @return
     */
    @Select("select * from Order")
    List<Order> queryAllOrder();

    /**
     * 条件查询采购订单
     */
    List<Order> findOrder(String orderid, Date createtime);
    /**
     * 新增采购订单
     *
     * @return
     */
    //@Insert("insert into order values(null,#{orderid},#{supplierid},#{purchaserid},#{rebate},#{paytype},#{total},#{amount_paid},#{total_tax},#{orderstate},#{preferential},#{costid})")
    int addOrder(Orders order);

    /**
     * 新增采购明细
     *
     * @return
     */
    //@Insert("insert into Detailed values(null,#{orderid},#{storehouseid},#{goodsid},#{number},#{tax},#{price},#{remarks}")
    int addDetailed(Detailed detailed);

    /**
     * 查询采购订单的明细顶到怕
     *
     * @return
     */
    @Select("select * from Detailed  where orderid = #{orderid}")
    List<Detailed> queryDetailed(int orderid);

    /**
     * 审核订单
     *
     * @return
     */
    //@Update("update Order set orderstate=2 where id=#{id}")
    int updateState(int id);

    /**
     * 转采购入库
     *
     * @return
     */
    //@Update("update Order set orderstate=3 where id=#{id}")
    int updateOrderState(int id);

    /**
     * 修改采购订单
     *
     * @return
     */
    //@Update("(update Order set supplierid=#{supplierid},purchaserid=#{purchaserid},rebate=#{rebate},amount_paid=#{amount_paid}   where id=#{id})")
    int updateOrder(int id,int supplierid,int purchaserid,int rebate,int amount_paid);

    /**
     * 添加采购支出
     *
     * @return
     */
    //@Insert("(insert into cost values(null,#{orderid},#{costtype},#{costprice}))")
    int addCost(Cost cost);


    /**
     * 删除采购支出
     *
     * @return
     */
    //@Delete("(delect from cost where id=#{id} )")
    int delectCost(int id);

    /**
     * 查采购支出
     *
     * @return
     */
   // @Select("(delect from cost where orderid=#{orderid} )")
    List<Cost> findCost(int orderid);

    /**
     * 修改采购支出
     *
     * @return
     */
    //@Update("(update  cost set costprice=#{costprice},costtype=#{costtype}  where id=#{id} )")
    int delectCost(int id,String costtype,int costprice);

    /**
     * 查询所有审核状态为 2 的订单费用
     * @return
     */
    @Select("select o.orderid as id,sl.supplier as sName,sl.accountNumber as accoun," +
            " o.purchaserid as pid,o.total as total,o.amount_paid as amount,ct.costtype as costType,ct.costprice as costPrice " +
            " from orders o LEFT JOIN cost ct ON o.costid=ct.id " +
            " LEFT JOIN supplier sl on o.supplierid=sl.id" +
            " where o.orderstate=2 and sl.type='供应商' and sl.delete_Flag=0 and o.finance=0 ")
    List<HashMap> incurExpense();

    /**
     * 修改财务记录添加状态
     * @param id
     * @return
     */
    @Update("update orders set finance=1 where orderid=#{id}")
    boolean updateFinance(Integer id);
}