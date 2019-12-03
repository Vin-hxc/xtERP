package com.xt.entity.zqw;


import java.sql.Timestamp;

public class Assemble {

  private long id;
  private long productId;
  private long pickingId;
  private java.sql.Timestamp assembyTime;
  private java.sql.Timestamp assembyendTime;
  private String assembledProducts;
  private long qualityTesting;

  public Assemble() {
  }

  public Assemble(long id, long productId, long pickingId, Timestamp assembyTime, Timestamp assembyendTime, String assembledProducts, long qualityTesting) {
    this.id = id;
    this.productId = productId;
    this.pickingId = pickingId;
    this.assembyTime = assembyTime;
    this.assembyendTime = assembyendTime;
    this.assembledProducts = assembledProducts;
    this.qualityTesting = qualityTesting;
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


  public long getPickingId() {
    return pickingId;
  }

  public void setPickingId(long pickingId) {
    this.pickingId = pickingId;
  }


  public java.sql.Timestamp getAssembyTime() {
    return assembyTime;
  }

  public void setAssembyTime(java.sql.Timestamp assembyTime) {
    this.assembyTime = assembyTime;
  }


  public java.sql.Timestamp getAssembyendTime() {
    return assembyendTime;
  }

  public void setAssembyendTime(java.sql.Timestamp assembyendTime) {
    this.assembyendTime = assembyendTime;
  }


  public String getAssembledProducts() {
    return assembledProducts;
  }

  public void setAssembledProducts(String assembledProducts) {
    this.assembledProducts = assembledProducts;
  }


  public long getQualityTesting() {
    return qualityTesting;
  }

  public void setQualityTesting(long qualityTesting) {
    this.qualityTesting = qualityTesting;
  }

}
