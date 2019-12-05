package com.xt.service.winter;

import com.xt.entity.winter.Recruit;

import java.util.HashMap;

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
     * 根据编号删除招聘信息
     * @param id
     * @return
     */
    boolean deleteRecruit(int id);
}
