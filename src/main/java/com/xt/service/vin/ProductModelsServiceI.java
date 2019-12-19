package com.xt.service.vin;

import com.xt.entity.vin.Product_model;
import com.xt.entity.vin.Product_type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface ProductModelsServiceI {
    /**
     * 查询所有产品型号
     * @return
     */
    public List<HashMap> getAllProductModels();

    /**
     * 新增产品型号
     * @param product_model
     * @return
     */
    public boolean insertProductModels(Product_model product_model);

    /**
     * 修改产品型号信息
     * @param product_model
     * @return
     */
    public boolean updateProductModels(Product_model product_model);

    /**
     * 修改产品型号删除标记
     * @param id
     * @return
     */
    public boolean deleteProductModels(long id);

    /**
     * 获取产品类别
     * @return
     */
    public List<Product_type> queryType();

    /**
     * 修改审核状态
     * @param id
     * @return
     */
    public boolean updateProductModelsStatus(long id);
}
