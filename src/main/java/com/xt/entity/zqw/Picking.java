package com.xt.entity.zqw;


import java.sql.Timestamp;

public class Picking {

  private long id;
  private String pickingNo;
  private String monitor;
  private String materialParts;
  private String materialNumber;
  private java.sql.Timestamp startTime;
  private String personCharge;
  private long productionAudit;

  public Picking() {
  }

  public Picking(long id, String pickingNo, String monitor, String materialParts, String materialNumber, Timestamp startTime, String personCharge, long productionAudit) {
    this.id = id;
    this.pickingNo = pickingNo;
    this.monitor = monitor;
    this.materialParts = materialParts;
    this.materialNumber = materialNumber;
    this.startTime = startTime;
    this.personCharge = personCharge;
    this.productionAudit = productionAudit;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getPickingNo() {
    return pickingNo;
  }

  public void setPickingNo(String pickingNo) {
    this.pickingNo = pickingNo;
  }


  public String getMonitor() {
    return monitor;
  }

  public void setMonitor(String monitor) {
    this.monitor = monitor;
  }


  public String getMaterialParts() {
    return materialParts;
  }

  public void setMaterialParts(String materialParts) {
    this.materialParts = materialParts;
  }


  public String getMaterialNumber() {
    return materialNumber;
  }

  public void setMaterialNumber(String materialNumber) {
    this.materialNumber = materialNumber;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
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
