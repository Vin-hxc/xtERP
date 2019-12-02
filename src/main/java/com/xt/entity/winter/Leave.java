package com.xt.entity.winter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Author Winter
 * @Date 2019/12/2 11:15
 * 请假实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Leave implements Serializable {
    private static final long serialVersionUID = 6483377675890330726L;
    private Integer leaveId;//请假编号
    private Integer userId;//用户编号
    private String reason;//请假原因
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private Integer allHour;//总时长
    private Integer verifyStatus;//审核 0通过 1未通过

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getAllHour() {
        return allHour;
    }

    public void setAllHour(Integer allHour) {
        this.allHour = allHour;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Leave() {
    }

    public Leave(Integer leaveId, Integer userId, String reason, Date startTime, Date endTime, Integer allHour, Integer verifyStatus) {
        this.leaveId = leaveId;
        this.userId = userId;
        this.reason = reason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.allHour = allHour;
        this.verifyStatus = verifyStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leave leave = (Leave) o;
        return Objects.equals(leaveId, leave.leaveId) &&
                Objects.equals(userId, leave.userId) &&
                Objects.equals(reason, leave.reason) &&
                Objects.equals(startTime, leave.startTime) &&
                Objects.equals(endTime, leave.endTime) &&
                Objects.equals(allHour, leave.allHour) &&
                Objects.equals(verifyStatus, leave.verifyStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveId, userId, reason, startTime, endTime, allHour, verifyStatus);
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", userId=" + userId +
                ", reason='" + reason + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", allHour=" + allHour +
                ", verifyStatus=" + verifyStatus +
                '}';
    }
}
