package com.xt.mapper.qxs.warehouse;

import com.xt.entity.qxs.warehouse.DepotItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 单据子表数据操作
 */
public interface DepotItemMapper {

    /**
     * 查询所有未删除的单据子表
     * @return
     */
    @Select("select * from depotItem where deleteFlag!='1' ")
    List<DepotItem> queryNotDeleteDepotItem();

    /**
     * 查询所有数据包括已删除的数据
     * @return
     */
    @Select("select * from depotItem ")
    List<DepotItem> queryAllDepotItem();

    /**
     * 根据depotHead Id 进行查询
     * @param id
     * @return
     */
    @Select("select * from depotItem where header=#{id} and deleteFlag!='1'")
    DepotItem getOnDepotHeadID(Integer id);

    /**
     * 查询被删除的数据
     * @return
     */
    @Select("select * from depotItem where deleteFlag='1' ")
    List<DepotItem> queryDelete();

    /**
     * 根据depotItem id进行查询
     * @param id
     * @return
     */
    @Select("select * from depotItem where id=#{id} and deleteFlag!='1'")
    DepotItem getOneDepotItem(Integer id);

    /**
     * 新增子单据，生成主表单据时调用此方法，实现同步添加
     * @param depotItem
     * @return
     */
    @Insert("insert into depotItem values(null,#{header},#{materialId},#{mUnit},#{basicNumber}," +
            "#{unitPrice},#{allPrice},#{remark},#{img},#{depot},#{mType},0)")
    boolean addDepotItem(DepotItem depotItem);

    /**
     * 修改单据子表数据
     * @param depotItem
     * @return
     */
    @Update("update depotItem set mUnit=#{mUnit},basicNumber=#{basicNumber}," +
            "remark=#{remark},img=#{img},mType=#{mType} where id=#{id}")
    boolean updateDepotItem(DepotItem depotItem);

    /**
     *  标记删除
     * @param flag 1：删除，0：不删除
     * @param id   条件
     * @return
     */
    @Update("update depotItem set deleteFlag=#{flag} where id=#{id}")
    boolean deleteFlagDepotItem(String flag,Integer id);

    /**
     * 查询物品是否存在
     * 存在则行数量修改，不存在进行添加
     * @param materialId
     * @return
     */
    @Select("select * from depotItem where materialId=#{materialId} and deleteFlag !=1")
    DepotItem queryDepotItemRecord(Integer materialId);

    /**
     * 修改数量
     * @param amount
     * @param materialID
     * @return
     */
    @Update("update depotItem set basicNumber=#{amount} where materialId=#{materialID}")
    boolean updateAmount(Integer amount,Integer materialID);

}
