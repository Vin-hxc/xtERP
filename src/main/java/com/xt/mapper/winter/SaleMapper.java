package com.xt.mapper.winter;

import com.xt.entity.winter.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Winter
 * @Date 2019/12/10 11:13
 * 销售数据持久操作
 */
public interface SaleMapper {
    /**
     * 添加销售信息
     * @param sale
     * @return
     */
    boolean saveSale(Sale sale);

    /**
     * 修改销售状态
     * @param state
     * @param id
     * @return
     */
    boolean updateSaleState(@Param("state") int state,
                            @Param("id") int id);

    /**
     * 修改所有销售信息
     * @param sale
     * @return
     */
    boolean updateSale(Sale sale);

    /**
     * 修改销售删除标记
     * @param deleteFlag
     * @param id
     * @return
     */
    boolean deleteSale(@Param("deleteFlag") int deleteFlag,
                       @Param("id") int id);

    /**
     * 未删除的销售数据
     * @return
     */
    List<Sale> getAllNoDeleteSale();

    /**
     * 已删除的销售数据
     * @return
     */
    List<Sale> getAllDeleteSale();

    /**
     * 查询所有销售数据
     * @return
     */
    List<Sale> getAllSale();

    /**
     * 查询单条销售数据
     * @param id
     * @return
     */
    Sale findSaleOne(int id);
}
