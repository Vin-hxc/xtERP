package com.xt.entity.zqw;


import java.sql.Timestamp;
import java.util.Date;

public class Dispatchedworker {

  private long id;//主键id
  private long productId;//产品编号
  private String dispatchedNo;//派工编号
  private String monitor;//负责班长
  private Date dispatchingTime;//派工时间
  private long dispatchedAudits;//派工审核是否通过 0-通过 1-不通过

  @Override
  public String toString() {
    return "Dispatchedworker{" +
            "id=" + id +
            ", productId=" + productId +
            ", dispatchedNo='" + dispatchedNo + '\'' +
            ", monitor='" + monitor + '\'' +
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

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public String getDispatchedNo() {
    return dispatchedNo;
  }

  public void setDispatchedNo(String dispatchedNo) {
    this.dispatchedNo = dispatchedNo;
  }

  public String getMonitor() {
    return monitor;
  }

  public void setMonitor(String monitor) {
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

  public Dispatchedworker(long id, long productId, String dispatchedNo, String monitor, Date dispatchingTime, long dispatchedAudits) {
    this.id = id;
    this.productId = productId;
    this.dispatchedNo = dispatchedNo;
    this.monitor = monitor;
    this.dispatchingTime = dispatchingTime;
    this.dispatchedAudits = dispatchedAudits;
  }
}
