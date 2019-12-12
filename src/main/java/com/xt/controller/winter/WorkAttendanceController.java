package com.xt.controller.winter;

import com.xt.entity.winter.WorkAttendance;
import com.xt.service.winter.WorkAttendanceServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Winter
 * @Date 2019/12/12 10:38
 */
@Controller
public class WorkAttendanceController {
    private Logger logger = LoggerFactory.getLogger(WorkAttendanceController.class);

    @Autowired
    private WorkAttendanceServiceI workAttendanceService;

    /**
     * 修改考勤数据
     * @param workAttendance
     * @return
     */
    public String updateWorkAttendance(WorkAttendance workAttendance){
        boolean flag = workAttendanceService.updateWorkAttendance(workAttendance);
        if (flag){
            return "forward:/getWork";
        }else{
            return "false";
        }
    }

    /**
     * 修改考勤时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param allHour 总时长
     * @param id 编号
     * @return
     */
    public String updateWorkAttendanceDate(Time startTime, Time endTime, Time allHour, int id) throws ParseException{
        return null;
    }

    /**
     * 查看该员工的考勤信息
     * 表格的
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/employeeAttendance")
    public String getEmployeeAttendance(int userId, Model model){
        List<WorkAttendance> employeeAttendance = workAttendanceService.getEmployeeAttendance(userId);
        model.addAttribute("employeeAttendance",employeeAttendance);
        return "winter/work/employeeAttendance";
    }

    /**
     * 查看该员工的考勤信息
     * 日历上的
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/work")
    public String getWorkAttendance(Model model){
        List<WorkAttendance> employeeAttendance = workAttendanceService.getEmployeeAttendance(1);
        model.addAttribute("work",employeeAttendance);
        return "winter/work/workDay";
    }
}
