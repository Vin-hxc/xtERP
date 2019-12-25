package com.xt.service.vin.impl;

import com.xt.entity.vin.Product_model;
import com.xt.entity.vin.Product_type;
import com.xt.mapper.vin.ProductModelsMapper;
import com.xt.service.vin.ProductModelsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@SuppressWarnings("all")
public class ProductModelsServiceImpl implements ProductModelsServiceI {

    @Autowired
    private ProductModelsMapper productModelsMapper;

    @Override
    public List<HashMap> getAllProductModels() {
        return productModelsMapper.getAllProductModels();
    }

    @Override
    public boolean insertProductModels(Product_model product_model) {
        return productModelsMapper.insertProductModels(product_model);
    }

    @Override
    public boolean updateProductModels(Product_model product_model) {
        return productModelsMapper.updateProductModels(product_model);
    }

    @Override
    public boolean deleteProductModels(long id) {
        return productModelsMapper.deleteProductModels(id);
    }

    @Override
    public List<Product_type> queryType() {
        return productModelsMapper.queryType();
    }

    @Override
    public boolean updateProductModelsStatus(long id) {
        return productModelsMapper.updateProductModelsStatus(id);
    }

    @Override
    public Product_model queryByModelId(long id) {
        return productModelsMapper.queryByModelId(id);
    }


}
