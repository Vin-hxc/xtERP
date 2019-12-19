package com.xt.service.zqw.impl;

import com.xt.entity.qxs.warehouse.Materials;
import com.xt.entity.zqw.Number;
import com.xt.entity.zqw.Picking;
import com.xt.entity.zqw.Productionplan;
import com.xt.mapper.zqw.NumberMapper;
import com.xt.mapper.zqw.PickingMapper;
import com.xt.mapper.zqw.ProductionplanMapper;
import com.xt.service.zqw.NumberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private PickingMapper pickingMapper;


    @Override
    public Boolean inserNum(int id, Date startTime, Date endTime, int personCharge, String[] number, int materialsId) {
        for (int i=0;i<number.length;i++){
            Number numbers = new Number(0, materialsId, number[i], personCharge);
            numberMapper.inserNum(numbers);
        }
        Date t = new Date();
        Productionplan productionplan = new Productionplan(0, id, startTime, endTime, personCharge, 0, 0, personCharge);
        boolean b1 = productionplanMapper.inserProuct(productionplan);
        Picking picking = new Picking(0, personCharge, t, 0, 0);
        boolean b = pickingMapper.inserPicking(picking);
        if (b&&b1){
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

    /**
     * 根据根据子表和生产查询id
     * @return
     */
    @Override
    public List<HashMap> selePadd() {
        return numberMapper.selePadd();
    }

}
