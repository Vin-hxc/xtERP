package com.xt.mapper.winter;

import com.xt.entity.winter.WorkAttendance;
import org.apache.ibatis.annotations.Param;

import java.sql.Time;
import java.util.Date;
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
     * 修改考勤时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param allHour 总时长
     * @param id 编号
     * @return
     */
    boolean updateWorkAttendanceDate(@Param("startTime") Time startTime,
                                     @Param("endTime") Time endTime,
                                     @Param("allHour") Time allHour,
                                     @Param("id") int id);

    /**
     * 查看该员工的考勤信息
     * @param userId
     * @return
     */
    List<WorkAttendance> getEmployeeAttendance(int userId);
}
