package com.xt.mapper.winter;

import com.xt.entity.winter.ApplyFor;

import java.util.List;

/**
 * @Author Winter
 * @Date 2019/12/6 12:04
 * 申请数据处理接口
 */
public interface ApplyForMapper {
    /**
     * 查看所有申请数据
     * 倒序
     * @return
     */
    List<ApplyFor> getAllApplyFor();

    /**
     * 添加申请数据
     * @param applyFor
     * @return
     */
    boolean saveApplyFor(ApplyFor applyFor);

    /**
     * 修改申请数据
     * @param applyFor
     * @return
     */
    boolean updateApplyFor(ApplyFor applyFor);

    /**
     * 删除申请数据
     * @param id
     * @return
     */
    boolean deleteApplyFor(int deleteFlag,int id);
}
