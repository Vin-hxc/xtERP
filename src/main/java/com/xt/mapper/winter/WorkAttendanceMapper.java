package com.xt.mapper.winter;

import com.xt.entity.winter.WorkAttendance;

import java.util.List;

/**
 * @Author Winter
 * @Date 2019/12/6 15:37
 * 考勤数据处理接口
 */
public interface WorkAttendanceMapper {
    /**
     * 修改考勤数据
     * @param workAttendance
     * @return
     */
    boolean updateWorkAttendance(WorkAttendance workAttendance);

    /**
     * 添加考勤
     * @param workAttendance
     * @return
     */
    boolean saveWorkAttendance(WorkAttendance workAttendance);

    /**
     * 修改考勤状态
     * @param state
     * @param id
     * @return
     */
    boolean updateWorkAttendanceState(int state,int id);

    /**
     * 查看该员工的考勤信息
     * @param userId
     * @return
     */
    List<WorkAttendance> getEmployeeAttendance(int userId);
    //根据员工编号查询考勤信息
}
