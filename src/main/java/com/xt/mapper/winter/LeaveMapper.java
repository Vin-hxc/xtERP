package com.xt.mapper.winter;

import com.xt.entity.winter.Leave;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Winter
 * @Date 2019/12/2 16:15
 * 请假 持久操作接口
 */
@Repository
public interface LeaveMapper {
    /**
     * 添加请假数据
     * @param leave
     * @return
     */
    public boolean saveLeave(Leave leave);

    /**
     * 修改请假数据
     * @param leave
     * @return
     */
    public boolean updateLeave(Leave leave);

    /**
     * 根据编号修改状态
     * 用于审核是否通过请假
     * @param id
     * @param verifyStatus
     * @return
     */
    public boolean updateLeaveStatus(int id,int verifyStatus);

    /**
     * 根据编号删除请假数据
     * @param id
     * @return
     */
    public boolean deleteLeave(int id);
}
