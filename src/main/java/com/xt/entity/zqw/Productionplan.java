package com.xt.entity.zqw;


import java.sql.Timestamp;

public class Productionplan {

  private long id;
  private long productId;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private String personCharge;
  private long productionAudit;

  public Productionplan() {
  }

  public Productionplan(long id, long productId, Timestamp startTime, Timestamp endTime, String personCharge, long productionAudit) {
    this.id = id;
    this.productId = productId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.personCharge = personCharge;
    this.productionAudit = productionAudit;
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


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public String getPersonCharge() {
    return personCharge;
  }

  public void setPersonCharge(String personCharge) {
    this.personCharge = personCharge;
  }


  public long getProductionAudit() {
    return productionAudit;
  }

  public void setProductionAudit(long productionAudit) {
    this.productionAudit = productionAudit;
  }

}
