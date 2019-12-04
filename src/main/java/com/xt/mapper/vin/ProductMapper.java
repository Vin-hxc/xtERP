package com.xt.mapper.vin;

import com.xt.entity.qxs.warehouse.Depothead;
import com.xt.entity.vin.Product;
import com.xt.entity.vin.Product_model;
import com.xt.entity.vin.Product_type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface ProductMapper {

    /**
     * 查询所有产品
     * @return List<Product>
     */
    @Select("select * from product where delete_Flag = '0'")
    public List<Product> getAllProduct();

    /**
     * 查询所有的产品类别
     * @return List<Product_type>
     */
    @Select("SELECT * FROM product_type where delete_Flag = '0'")
    public List<Product_type> getProductType();

    /**
     * 查询所有产品型号
     * @return List<Product_model>
     */
    @Select("SELECT * FROM product_model where delete_Flag = '0'")
    public List<Product_model> getProductModel();

    /**
     * 根据产品id查询
     * @return Product
     */
    @Select("select * from product where delete_Flag = '0' AND id = #{id}")
    public Product getProductById(long id);

    /**
     * 添加新的产品信息
     * @param product
     * @return boolean
     */
    @Insert("INSERT INTO product (product_name,product_model,product_type,product_unit,product_stock,retail_price,min_price,cost_price,trade_price,product_state,serial_number,delete_Flag)" +
            "VALUES(#{product_name},#{product_model},#{product_type},#{product_unit},#{product_stock},#{retail_price},#{min_price},#{cost_price},#{trade_price},#{product_state},#{serial_number},'0')")
    public boolean insertProduct(Product product);

    /**
     * 修改产品信息
     * @param product
     * @return boolean
     */
    @Update("UPDATE product SET product_name=#{product_name},product_model=#{product_model},product_type=#{product_type},product_unit=#{product_unit},product_stock=#{product_stock},retail_price=#{retail_price},min_price=#{min_price},cost_price=#{cost_price},trade_price=#{trade_price} WHERE id=#{id} and delete_Flag='0'")
    public boolean updateProduct(Product product);

    /**
     * 删除产品信息（删除标记）
     * @param id
     * @return boolean
     */
    @Update("UPDATE product SET delete_Flag='1' where id = #{id} and delete_Flag='0'")
    public boolean deleteProduct(long id);

    /**
     * 查询产品型号
     * @param id
     * @return Product_model
     */
    @Select("SELECT * from product_model WHERE id=#{id} and delete_Flag='0'")
    public Product_model getProductModel(long id);

    /**
     * 查询产品库存信息
     * @return List<Depothead>
     */
    @Select("")
    public List<Depothead> getProductStock();

    /**
     * 修改产品状态
     * @param id
     * @return boolean
     */
    public boolean updateProductState(long id);
}
