
package com.xt.mapper.zqw;
import com.xt.entity.zqw.Productionplan;
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
    @Select("select * from productionplan")
    List<HashMap> seleProuct();
    /**
     * 添加一个生产计划
     * @param productionplan
     * @return
     */
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
}
