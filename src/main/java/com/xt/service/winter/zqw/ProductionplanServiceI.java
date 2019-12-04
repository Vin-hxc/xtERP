package com.xt.service.winter.zqw;

import com.xt.entity.zqw.Productionplan;

/**
 * 生产计划业务操作接口
 */
public interface ProductionplanServiceI {
    /**
     * 添加一个生产计划
     * @param productionplan
     * @return
     */
    boolean inserProuct(Productionplan productionplan);

    /**
     * 修改生产计划
     * @param productionplan
     * @return
     */
    boolean updatePeouct(Productionplan productionplan);

    /**
     * 根据id删除生产计划
     * @param id
     * @return
     */
    boolean deletePeouct(int id);
}
