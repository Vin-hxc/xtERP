package com.xt.mapper.qxs.warehouse;

import com.xt.entity.qxs.warehouse.Depothead;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 单据主表数据操作
 */
public interface DepotHeadMapper {

    /**
     * 查询所有单据主表
     * @return
     */
    @Select("select * from depotHead where delete_Flag!='1' order by createTime desc")
    List<Depothead> queryAllDepotHead();

    /**
     * 根据票据号查询当前记录
     * @param number
     * @return
     */
    @Select("select * from depotHead where number=#{number} and delete_Flag='1'")
    Depothead getOneDepotHead(String number);

    /**
     * 查询被删除的数据
     * @return
     */
    @Select("select * from depotHead where delete_Flag!='1'")
    List<Depothead> queryDelete();

    /**
     * 新增主表数据
     * @param depothead
     * @return
     */
    @Insert("insert into depotHead values(null,#{type},#{number},#{operPersonName},#{createTime}," +
            "#{operTime},#{organId},#{handsPersonId},#{account},#{changeAmount},#{totalPrice},#{payType}," +
            "#{remark},#{accountDay},0,0)")
    boolean addDepotHead(Depothead depothead);

    /**
     * 修改数据
     * @param depothead
     * @return
     */
    @Update("update depotHead set operTime=#{operTime},organId=#{organId},handsPersonId=#{handsPersonId}," +
            "account=#{account},changeAmount=#{changeAmount},totalPrice=#{totalPrice},payType=#{payType}," +
            "remark=#{remark},accountDay=#{accountDay} where id=#{id}")
    boolean updateDepotHead(Depothead depothead);

    /**
     * 审批
     * @param status 1:已审核 0:未审核 2：不通过 默认 0 其他数值为待审核
     * @return
     */
    @Update("update depotHead set status=#{status} where id=#{id}")
    boolean depotHeadExamin(String status,Integer id);

    /**
     * 标记删除
     * @param deleteFlag 1 删除 0 未删除 默认 0
     * @param id 条件
     * @return
     */
    boolean deleteDepotHead(String deleteFlag,Integer id);
}
