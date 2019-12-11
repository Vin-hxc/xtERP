package com.xt.controller.winter;

import com.xt.entity.winter.Leave;
import com.xt.service.winter.LeaveServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Winter
 * @Date 2019/12/11 15:46
 */
@Controller
public class LeaveController {
    @Autowired
    private LeaveServiceI leaveService;

    /**
     * 添加请假数据
     * @param leave
     * @return
     */
    @RequestMapping("/saveLeave")
    public String saveLeave(Leave leave){
        boolean flag = leaveService.saveLeave(leave);
        if (flag){
            return "/getLeave";
        }else {
            return "false";
        }
    }

    /**
     * 修改请假数据
     * @param leave
     * @return
     */
    @RequestMapping("/updateLeave")
    public String updateLeave(Leave leave){
        boolean flag = leaveService.updateLeave(leave);
        if (flag){
            return "/getLeave";
        }else {
            return "false";
        }
    }

    /**
     * 根据编号修改状态
     * 用于审核是否通过请假
     * @param leaveId
     * @param verifyStatus
     * @return
     */
    public String updateLeaveStatus( int leaveId, int verifyStatus){
        return null;
    }

    /**
     * 根据编号删除请假数据
     * @param deleteFlag
     * @param leaveId
     * @return
     */
    public String deleteLeave(int deleteFlag,int leaveId){
        return null;
    }

    /**
     * 未被删除的请假数据
     * @return
     */
    public String getAllNoDeleteLeave(){
        return null;
    }

    /**
     * 已被删除的请假数据
     * @return
     */
    public String getAllDeleteLeave(){
        return null;
    }

    /**
     * 所有请假数据
     * @return
     */
    public String getAllLeave(){
        return null;
    }

    /**
     * 根据编号查询单条请假数据
     * @param leaveId
     * @return
     */
    public String findLeaveOne(int leaveId){
        return null;
    }
}
