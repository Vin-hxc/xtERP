package com.xt.service.winter.zqw.impl;

import com.xt.entity.zqw.Productionplan;
import com.xt.mapper.zqw.ProductionplanMapper;
import com.xt.service.winter.zqw.ProductionplanServiceI;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 生产计划业务实现类
 */
@Service
public class ProductionplanServiceImpl implements ProductionplanServiceI {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 添加一个生产计划
     * @param productionplan
     * @return
     */
    @Override
    public boolean inserProuct(Productionplan productionplan) {
        ProductionplanMapper mapper = sqlSessionTemplate.getMapper(ProductionplanMapper.class);
        return mapper.inserProuct(productionplan);
    }

    /**
     * 修改生产计划
     * @param productionplan
     * @return
     */
    @Override
    public boolean updatePeouct(Productionplan productionplan) {
        ProductionplanMapper mapper = sqlSessionTemplate.getMapper(ProductionplanMapper.class);
        return mapper.updatePeouct(productionplan);
    }

    /**
     * 删除生产计划
     * @param id
     * @return
     */
    @Override
    public boolean deletePeouct(int id) {
        ProductionplanMapper mapper = sqlSessionTemplate.getMapper(ProductionplanMapper.class);
        return mapper.deletePeouct(id);
    }
}
