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
@Service
public class RecruitServiceImpl implements RecruitServiceI {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    /**
     * 添加招聘信息
     * @param recruit
     * @return
     */
    @Override
    public boolean saveRecruit(Recruit recruit) {
        RecruitMapper mapper = sqlSessionTemplate.getMapper(RecruitMapper.class);
        return mapper.saveRecruit(recruit);
    }

    /**
     * 修改招聘信息
     * @param recruit
     * @return
     */
    @Override
    public boolean updateRecruit(Recruit recruit) {
        RecruitMapper mapper = sqlSessionTemplate.getMapper(RecruitMapper.class);
        return mapper.updateRecruit(recruit);
    }

    /**
     * 根据编号删除招聘信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteRecruit(int id) {
        RecruitMapper mapper = sqlSessionTemplate.getMapper(RecruitMapper.class);
        return mapper.deleteRecruit(id);
    }
}
