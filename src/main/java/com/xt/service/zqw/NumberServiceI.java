package com.xt.service.zqw;

import com.xt.entity.qxs.warehouse.Materials;
import com.xt.entity.zqw.Number;
import com.xt.entity.zqw.Picking;
import com.xt.entity.zqw.Productionplan;

import java.util.HashMap;
import java.util.List;

/**
 * 物料数量的业务层操作接口
 */
public interface NumberServiceI {
    /**
     * 添加物料数量
     * @param number
     * @return
     */
    Boolean inserNum(Number number, Picking picking, Productionplan productionplan);

    /**
     * 查询材料表信息
     * @return
     */
    List<Materials> seleMat();

    /**
     * 查询领料信息
     * @return
     */
    List<Picking> selepicking();

    /**
     * 查询生产计划
     * @return
     */
    List<Productionplan> seleProduct();

    /**
     * 根据根据子表和生产查询id
     * @return
     */
    List<HashMap> selePadd();
}
