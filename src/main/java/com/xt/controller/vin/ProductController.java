package com.xt.controller.vin;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xt.entity.vin.Product;
import com.xt.entity.vin.Product_model;
import com.xt.entity.vin.Product_type;
import com.xt.mapper.vin.ProductMapper;
import com.xt.service.vin.ProductServiceI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProductController {
    @Resource
    private ProductServiceI productServiceI;


    @RequestMapping("/getAllProduct")
    public String getAllProduct(HttpServletRequest request){
        List<HashMap> listproducthash = productServiceI.getAllProduct();
        request.setAttribute("product",listproducthash);
        for (HashMap pro : listproducthash){
            System.out.println(pro);
        }
        return  "vin/product";
    }

    @RequestMapping("/getProductModel")
    public String getProductModel(HttpServletRequest request){
        List<Product_model> product_models = productServiceI.getProductModel();
        request.setAttribute("productModel",product_models);
        for (Product_model models : product_models){
            System.out.println(models);
        }
        return "vin/product";
    }

    @RequestMapping("/getProductById")
    public String getProductById(HttpServletRequest request,long id){
        Product product = productServiceI.getProductById(id);
        if (product!=null){
            System.out.println(product);
        }
        return "vin/product";
    }

    @RequestMapping("/insert_Product")
    public String insertProduct(Product product, Model model){
        List<Product_model> product_models = productServiceI.getProductModel();

        model.addAttribute("product_models",product_models);
        for (Product_model list : product_models){
            System.out.println(list);
        }
        return "vin/insertProduct";
    }

    @RequestMapping("/queryByModelName")
    @ResponseBody
    public Product_type queryByModelName(Integer model_id){
        System.out.println(model_id);
        Product_type product_type = productServiceI.queryByModelName(model_id);
        if(product_type!=null){
            System.out.println(product_type);
        }
        return product_type;
    }

    @RequestMapping("/insertProduct")
    public String insertProduct(){
        return "";
    }
}
