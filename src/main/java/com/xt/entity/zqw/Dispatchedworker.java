package com.xt.entity.zqw;


import java.sql.Timestamp;
import java.util.Date;

public class Dispatchedworker {

  private long id;//主键id
  private long dispatchedNo;//派工编号
  private long monitor;//负责人id
  private Date dispatchingTime;//派工时间
  private long dispatchedAudits;//派工审核是否通过 0-通过 1-不通过

  @Override
  public String toString() {
    return "Dispatchedworker{" +
            "id=" + id +
            ", dispatchedNo=" + dispatchedNo +
            ", monitor=" + monitor +
            ", dispatchingTime=" + dispatchingTime +
            ", dispatchedAudits=" + dispatchedAudits +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getDispatchedNo() {
    return dispatchedNo;
  }

  public void setDispatchedNo(long dispatchedNo) {
    this.dispatchedNo = dispatchedNo;
  }

  public long getMonitor() {
    return monitor;
  }

  public void setMonitor(long monitor) {
    this.monitor = monitor;
  }

  public Date getDispatchingTime() {
    return dispatchingTime;
  }

  public void setDispatchingTime(Date dispatchingTime) {
    this.dispatchingTime = dispatchingTime;
  }

  public long getDispatchedAudits() {
    return dispatchedAudits;
  }

  public void setDispatchedAudits(long dispatchedAudits) {
    this.dispatchedAudits = dispatchedAudits;
  }

  public Dispatchedworker() {
  }

  public Dispatchedworker(long id, long dispatchedNo, long monitor, Date dispatchingTime, long dispatchedAudits) {
    this.id = id;
    this.dispatchedNo = dispatchedNo;
    this.monitor = monitor;
    this.dispatchingTime = dispatchingTime;
    this.dispatchedAudits = dispatchedAudits;
  }
}
