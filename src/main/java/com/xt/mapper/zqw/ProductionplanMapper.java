
package com.xt.mapper.zqw;
import com.xt.entity.vin.Product_model;
import com.xt.entity.zqw.Picking;
import com.xt.entity.zqw.Productionplan;
import com.xt.entity.zqw.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

/**
 * 生产计划持久层操作接口
 */
@Repository
public interface ProductionplanMapper {
    /**
     * 查询生产计划
     * @return
     */
    @Select("SELECT productionPlan.*,product.product_name,userInfo.userName,product_model.* FROM productionPlan,product,userInfo,picking,product_model where\n" +
            "productionPlan.productId=product.id and productionPlan.personCharge=userInfo.id and picking.pickingNo=product_model.id")
    List<HashMap> seleProuct();
    /**
     * 添加一个生产计划
     * @param productionplan
     * @return
     */
    @Insert("insert into productionplan(id,productId,startTime,endTime,personCharge,productionAudit,deleteProd,prquantity) values " +
            "(null,#{productId},#{startTime},#{endTime},#{personCharge},#{productionAudit},#{deleteProd},#{prquantity})")
    boolean inserProuct(Productionplan productionplan);

    /**
     * 修改生产计划
     * @param productionplan
     * @return
     */
    boolean updatePeouct(Productionplan productionplan);

    /**
     * 根据id删除生产计划
     * @param id
     * @return
     */
    boolean deletePeouct(int id);

    /**
     * 根据申请表查询产品名称
     * @return
     */
    @Select("SELECT productionPlan.productId,applyFor.productId,product.product_name from applyFor,product,productionPlan WHERE \n" +
            "applyFor.productId =product.id and productionPlan.productId=product.id")
    List<HashMap> dgselepro();

    /**
     * 查询产品信息
     * @return
     */
    @Select("select product_model.*,picking.*,productionplan.* from productionplan,picking,product_model WHERE picking.productionid=productionplan.id")
    List<HashMap> selepm();

    /**
     * 查询产品信息
     * @return
     */
    @Select("select * from product_model")
    List<Product_model> selepmll();

    /**
     * 添加领料信息
     * @param picking
     * @return
     */
    @Insert("insert into picking(id,pickingNo,materialNumber,startTime,productionAudit,deletePick) values " +
            "(null,#{pickingNo},#{materialNumber},#{startTime},#{productionAudit},#{deletePick})")
    boolean inserpick(Picking picking);

    /**
     * 查询用户姓名
     * @return
     */
    @Select("select * from userinfo")
    List<Userinfo> seleuser();
}
