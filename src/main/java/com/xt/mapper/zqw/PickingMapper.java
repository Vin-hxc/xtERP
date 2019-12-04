package com.xt.mapper.zqw;

import com.xt.entity.zqw.Picking;

import java.util.HashMap;

/**
 * 领料持久层操作接口
 */
public interface PickingMapper {
    /**
     * 查询领料信息
     * @return
     */
    HashMap selePicking();

    /**
     * 添加领料信息
     * @param picking
     * @return
     */
    boolean inserPicking(Picking picking);

    /**
     * 修改领料信息
     * @param picking
     * @return
     */
    boolean updatePicking(Picking picking);

    /**
     * 根据id删除领料信息
     * @param id
     * @return
     */
    boolean deletePicking(int id);
}
