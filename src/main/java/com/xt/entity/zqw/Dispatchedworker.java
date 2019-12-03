package com.xt.entity.zqw;


import java.sql.Timestamp;

public class Dispatchedworker {

  private long id;
  private long productId;
  private String dispatchedNo;
  private String monitor;
  private java.sql.Timestamp dispatchingTime;
  private long dispatchedAudits;

  public Dispatchedworker() {
  }

  public Dispatchedworker(long id, long productId, String dispatchedNo, String monitor, Timestamp dispatchingTime, long dispatchedAudits) {
    this.id = id;
    this.productId = productId;
    this.dispatchedNo = dispatchedNo;
    this.monitor = monitor;
    this.dispatchingTime = dispatchingTime;
    this.dispatchedAudits = dispatchedAudits;
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


  public java.sql.Timestamp getDispatchingTime() {
    return dispatchingTime;
  }

  public void setDispatchingTime(java.sql.Timestamp dispatchingTime) {
    this.dispatchingTime = dispatchingTime;
  }


  public long getDispatchedAudits() {
    return dispatchedAudits;
  }

  public void setDispatchedAudits(long dispatchedAudits) {
    this.dispatchedAudits = dispatchedAudits;
  }

}
