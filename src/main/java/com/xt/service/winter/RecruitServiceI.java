package com.xt.service.winter;

import com.xt.entity.winter.Recruit;

import java.util.List;

/**
 * @Author Winter
 * @Date 2019/12/3 8:42
 * 招聘业务操作接口
 */
public interface RecruitServiceI {
    /**
     * 添加招聘信息
     * @param recruit
     * @return
     */
    boolean saveRecruit(Recruit recruit);

    /**
     * 修改招聘信息
     * @param recruit
     * @return
     */
    boolean updateRecruit(Recruit recruit);

    /**
     * 删除招聘信息
     * @param id
     * @return
     */
    boolean deleteRecruit(int deleteFlag, int id);

    /**
     * 查询所有未删除的招聘信息
     * @return
     */
    List<Recruit> getAllNoDeleteRecruit();

    /**
     *查询所有已删除的招聘信息
     * @return
     */
    List<Recruit> getAllDeleteRecruit();

    /**
     * 查询所有招聘信息
     * @return
     */
    List<Recruit> getAllRecruit();

    /**
     * 根据编号查询单条招聘信息
     * @param id
     * @return
     */
    Recruit findRecruitOne(int id);
}
