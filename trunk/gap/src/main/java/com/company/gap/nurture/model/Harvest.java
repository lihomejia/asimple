package com.company.gap.nurture.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_nurture_harvest")
public class Harvest extends GeneralModel {
	
	@Column(name="register_id", columnDefinition="int default 0")
	private Integer registerId;
	
	@Column(name="cell_id", columnDefinition="int default 0")
	private Integer cellId;
	
	@Column(length=100)
	private String product;
	
	@Column(columnDefinition="int default 0")
	private Integer batch;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date operatedate;
	
	@Column(length=60)
	private String method;
	
	@Column(columnDefinition="decimal(10, 2) default 0")
	private Double scale;
	
	@Column(columnDefinition="decimal(10, 2) default 0")
	private Double yield;
	
	@Column(length=60)
	private String storage;
	
	@Column(length=60)
	private String respmanager;
	
	@Column(length=60)
	private String storemanager;

	public Integer getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getCellId() {
		return cellId;
	}

	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getBatch() {
		return batch;
	}

	public void setBatch(Integer batch) {
		this.batch = batch;
	}

	public Date getOperatedate() {
		return operatedate;
	}

	public void setOperatedate(Date operatedate) {
		this.operatedate = operatedate;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getRespmanager() {
		return respmanager;
	}

	public void setRespmanager(String respmanager) {
		this.respmanager = respmanager;
	}

	public String getStoremanager() {
		return storemanager;
	}

	public void setStoremanager(String storemanager) {
		this.storemanager = storemanager;
	}
}
