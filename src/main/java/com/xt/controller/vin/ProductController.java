package com.xt.controller.vin;

import com.xt.entity.vin.Product;
import com.xt.entity.vin.Product_model;
import com.xt.mapper.vin.ProductMapper;
import com.xt.service.vin.ProductServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/insertProduct")
    public String insertProduct(Product product, Model model){
        List<Product_model> product_models = productServiceI.getProductModel();
        model.addAttribute("product_models",product_models);
        System.out.println(product);
        return "vin/insertProduct";
    }
}
