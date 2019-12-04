package com.xt.mapper.qxs.finance;

import com.xt.entity.qxs.finance.Income;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 财政收入明细数据操作
 */
public interface IncomeMapper {

    /**
     * 查询所有未删除的财政收入记录
     * @return
     */
    @Select("select * from income where deleteFlag!=1 order by date_recorded desc")
    List<Income> queryAllIncome();


}
