package com.xt.service.vin.impl;

import com.xt.entity.qxs.warehouse.Depothead;
import com.xt.entity.vin.Product;
import com.xt.entity.vin.Product_model;
import com.xt.entity.vin.Product_type;
import com.xt.mapper.vin.ProductMapper;
import com.xt.service.vin.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@SuppressWarnings("all")
public class ProductServiceImpl implements ProductServiceI {
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<HashMap> getAllProduct() {
        return productMapper.getAllProduct();
    }

    @Override
    public List<Product_type> getProductType() {
        return productMapper.getProductType();
    }

    @Override
    public List<Product_model> getProductModel() {
        return productMapper.getProductModel();
    }

    @Override
    public Product getProductById(long id) {
        return productMapper.getProductById(id);
    }

    @Override
    public boolean insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(long id) {
        return productMapper.deleteProduct(id);
    }

    @Override
    public Product_model getProductModelById(long id) {
        return productMapper.getProductModelById(id);
    }

    @Override
    public List<Depothead> getProductStock() {
        return productMapper.getProductStock();
    }

    @Override
    public boolean updateProductState(long id) {
        return productMapper.updateProductState(id);
    }

    @Override
    public Product_type queryByModelName(long id) {
        return productMapper.queryByModelName(id);
    }
}
