package com.xt.service.winter.impl;

import com.xt.entity.winter.Recruit;
import com.xt.mapper.winter.RecruitMapper;
import com.xt.service.winter.RecruitServiceI;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Winter
 * @Date 2019/12/3 8:43
 * 招聘业务实现类
 */
@SuppressWarnings("all")
@Service
public class RecruitServiceImpl implements RecruitServiceI {
    @Autowired(required = true)
    private RecruitMapper recruitMapper;
    /**
     * 添加招聘信息
     * @param recruit
     * @return
     */
    @Override
    public boolean saveRecruit(Recruit recruit) {
        return recruitMapper.saveRecruit(recruit);
    }

    /**
     * 修改招聘信息
     * @param recruit
     * @return
     */
    @Override
    public boolean updateRecruit(Recruit recruit) {
        return recruitMapper.updateRecruit(recruit);
    }

    /**
     * 根据编号删除招聘信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteRecruit(int id) {
        return recruitMapper.deleteRecruit(id);
    }
}
