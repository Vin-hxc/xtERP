package com.xt.service.zqw.impl;

import com.xt.entity.qxs.warehouse.Materials;
import com.xt.entity.zqw.Number;
import com.xt.entity.zqw.Picking;
import com.xt.entity.zqw.Productionplan;
import com.xt.mapper.zqw.NumberMapper;
import com.xt.mapper.zqw.ProductionplanMapper;
import com.xt.service.zqw.NumberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 所需物料数量业务实现类
 */
@Service
public class NumberServiceImpl implements NumberServiceI {
    @Autowired
    private NumberMapper numberMapper;
    @Autowired
    private  ProductionplanMapper productionplanMapper;
    @Override
    public Boolean inserNum(Number number, Picking picking, Productionplan productionplan) {
        Boolean aBoolean = numberMapper.inserNum(number);
        System.out.println(picking.getStartTime()+"--------------------------->sj");
        boolean inserpick = productionplanMapper.inserpick(picking);
        boolean b = productionplanMapper.inserProuct(productionplan);
        if (aBoolean && inserpick && b){
            return true;
        }
        return false;
    }

    @Override
    public List<Materials> seleMat() {
        return numberMapper.seleMat();
    }

    @Override
    public List<Picking> selepicking() {
        return numberMapper.selepicking();
    }

    @Override
    public List<Productionplan> seleProduct() {
        return numberMapper.seleProduct();
    }

}
