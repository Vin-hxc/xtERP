package com.xt.mapper.qxs.finance;

import com.xt.entity.qxs.finance.Account;
import com.xt.entity.qxs.finance.Summarizing;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 财政汇总记录数据操作
 */
public interface SummarizingMapper {

    /**
     * 查询所有未删除的记录
     * @return
     */
    @Select("select * from summarizing where deleteFlag != 1 order by collect_date desc")
    List<Summarizing> queryNotDeleteSummarizing();

    /**
     * 查询所有已删除数据
     * @return
     */
    @Select("select * from summarizing where deleteFlag=1 order by collect_date desc")
    List<Summarizing> queryDeleteSummarizing();

    /**
     * 查询所有记录，包括已删除的
     * @return
     */
    @Select("select * from summarizing order by collect_date desc")
    List<Summarizing> queryAllSummarizing();

    /**
     * 根据id获取当前记录
     * @param id
     * @return
     */
    @Select("select * from summarizing where id=#{id} and deleteFlag!=1")
    Summarizing getOneSummarizing(Integer id);

    /**
     * 修改汇总记录
     * @param account
     * @return
     */
    boolean updateSummarizing(Account account);

    /**
     * 标记删除
     * @param deleteFlag 0：不删除；1：删除； 默认0
     * @param id
     * @return
     */
    @Select("select * from summarizing deleteFlag=#{deleteFlag} where id=#{id}")
    boolean deleteSummarizing(Integer deleteFlag,Integer id);

    /**
     * 新增财务汇总记录
     * @param summarizing
     * @return
     */
    @Insert("insert into summarizing values(null,#{financialSettlement},#{collect_date},#{principal}," +
            "#{describe},0)")
    boolean addSummarizing(Summarizing summarizing);
}
