package com.xt.entity.zqw;


import java.sql.Timestamp;
import java.util.Date;

public class Picking {
  private long id;//主键id
  private String pickingNo;//领料编号
  private long monitor;//负责人id
  private String materialParts;//物料零件
  private String materialNumber;//物料数量
  private Date startTime;//出库时间
  private long productionAudit;//物料审核是否通过 0-通过 1-不通过
  private long deletePick;//删除标记

  @Override
  public String toString() {
    return "Picking{" +
            "id=" + id +
            ", pickingNo='" + pickingNo + '\'' +
            ", monitor=" + monitor +
            ", materialParts='" + materialParts + '\'' +
            ", materialNumber='" + materialNumber + '\'' +
            ", startTime=" + startTime +
            ", productionAudit=" + productionAudit +
            ", deletePick=" + deletePick +
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

  public long getMonitor() {
    return monitor;
  }

  public void setMonitor(long monitor) {
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

  public long getProductionAudit() {
    return productionAudit;
  }

  public void setProductionAudit(long productionAudit) {
    this.productionAudit = productionAudit;
  }

  public long getDeletePick() {
    return deletePick;
  }

  public void setDeletePick(long deletePick) {
    this.deletePick = deletePick;
  }

  public Picking() {
  }

  public Picking(long id, String pickingNo, long monitor, String materialParts, String materialNumber, Date startTime, long productionAudit, long deletePick) {
    this.id = id;
    this.pickingNo = pickingNo;
    this.monitor = monitor;
    this.materialParts = materialParts;
    this.materialNumber = materialNumber;
    this.startTime = startTime;
    this.productionAudit = productionAudit;
    this.deletePick = deletePick;
  }
}
