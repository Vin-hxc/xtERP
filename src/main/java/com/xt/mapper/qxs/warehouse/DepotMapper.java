package com.xt.mapper.qxs.warehouse;

import com.xt.entity.qxs.warehouse.Depot;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

/**
 * 仓库数据操作
 */
public interface DepotMapper {

    /**
     * 查询所有仓库
     * @return
     */
    @Select("select * from depot where !=1delete_Flag order by sort desc")
    List<Depot> queryAllDepot();

    /**
     * 获取仓库名
     * @param name
     * @return
     */
    @Select("select * from depot where name=#{name} and delete_flag!='1' ")
    Depot getDepotName(String name);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    @Select("select * from ")
    Depot getOneDepot(Integer id);

    /**
     * 修改仓库信息
     * @param depot
     * @return
     */
    @Update("update depot name=#{name},address=#{address},truckage=#{truckage},type=#{type}," +
            "remark=#{remark},principal=#{principal} where id=#{id} ")
    boolean updateDepot(Depot depot);

    /**
     * 仓库默认设置
     * @param isDefault 0 默认 1 不默认；默认为1
     * @return
     */
    @Update("update depot set isDefault=#{isDefault} where id=#{id}")
    boolean defaultDepot(Integer isDefault, Integer id);

    /**
     * 标记删除
     * @param deleteFlag 0 未删除；1 已删除 默认 0
     * @param id 删除条件
     * @return
     */
    @Update("update depot set delete_Flag=#{deleteFlag} where id=#{id}")
    boolean deleteDepot(String deleteFlag,Integer id);
}
