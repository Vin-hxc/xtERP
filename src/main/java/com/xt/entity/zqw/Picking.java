package com.xt.entity.zqw;


import java.sql.Timestamp;
import java.util.Date;

public class Picking {
  private long id;//主键id
  private String pickingNo;//领料编号
  private String monitor;//负责班长
  private String materialParts;//物料零件
  private String materialNumber;//物料数量
  private Date startTime;//出库时间
  private String personCharge;//负责人
  private long productionAudit;//物料审核是否通过 0-通过 1-不通过

  @Override
  public String toString() {
    return "Picking{" +
            "id=" + id +
            ", pickingNo='" + pickingNo + '\'' +
            ", monitor='" + monitor + '\'' +
            ", materialParts='" + materialParts + '\'' +
            ", materialNumber='" + materialNumber + '\'' +
            ", startTime=" + startTime +
            ", personCharge='" + personCharge + '\'' +
            ", productionAudit=" + productionAudit +
            '}';
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

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
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

  public Picking() {
  }

  public Picking(long id, String pickingNo, String monitor, String materialParts, String materialNumber, Date startTime, String personCharge, long productionAudit) {
    this.id = id;
    this.pickingNo = pickingNo;
    this.monitor = monitor;
    this.materialParts = materialParts;
    this.materialNumber = materialNumber;
    this.startTime = startTime;
    this.personCharge = personCharge;
    this.productionAudit = productionAudit;
  }
}
