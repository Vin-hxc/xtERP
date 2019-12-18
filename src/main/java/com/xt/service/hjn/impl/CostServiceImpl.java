package com.xt.service.hjn.impl;

import com.xt.entity.hjn.Cost;
import com.xt.mapper.hjn.CostMapper;
import com.xt.service.hjn.CostServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: xterp
 * @description: CostServiceImpl
 * @author: hjn
 * @create: 2019-12-16 10:01
 **/
@Service
public class CostServiceImpl implements CostServicel {
    @Autowired
    private CostMapper costMapper;
    public CostMapper getCostMapper() {
        return costMapper;
    }

    /**
     * 添加采购支出
     * @param cost
     * @return
     */
    @Override
    public int addCost(Cost cost) {
        return costMapper.addCost(cost);
    }

    /**
     * 删除采购支出
     */
    @Override
    public int delectCost(int id) {
        return costMapper.delectCost(id);
    }

    /**
     * 查采购支出
     *
     * @return
     */
    @Override
    public List<Cost> findCost(int orderid) {
        return costMapper.findCost(orderid);
    }

    /**
     * 修改采购支出
     *
     * @return
     */
    @Override
    public int delectCost(int id, String costtype, int costprice) {
        return costMapper.delectCost(id,costtype,costprice);
    }
}
