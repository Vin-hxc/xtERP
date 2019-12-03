package com.xt.entity.zqw;


import java.sql.Timestamp;
import java.util.Date;

public class Productionplan {

  private long id;//主键id
  private long productId;//产品编号
  private Date startTime;//开始时间
  private Date endTime;//预计结束时间
  private String personCharge;//负责人
  private long productionAudit;//生产审核是否通过 0-通过 1-不通过

  @Override
  public String toString() {
    return "Productionplan{" +
            "id=" + id +
            ", productId=" + productId +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
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

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
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

  public Productionplan() {
  }

  public Productionplan(long id, long productId, Date startTime, Date endTime, String personCharge, long productionAudit) {
    this.id = id;
    this.productId = productId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.personCharge = personCharge;
    this.productionAudit = productionAudit;
  }
}
