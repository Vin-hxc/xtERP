package com.xt.mapper.zqw;

import com.xt.entity.zqw.Number;
import org.apache.ibatis.annotations.Insert;

/**
 * 所需物料数量持久层操作接口
 */
public interface NumberMapper {
    /**
     * 添加所需物料数量
     * @param number
     * @return
     */
    @Insert("insert into number(id,numberzb,numbercpu,numbernc,numberxk,numberyp,numbergtyp,pickid) values (null,#{numberzb},#{numbercpu},#{numbernc},#{numberxk},#{numberyp},#{numbergtyp},#{pickid})")
    Boolean inserNum(Number number);
}
