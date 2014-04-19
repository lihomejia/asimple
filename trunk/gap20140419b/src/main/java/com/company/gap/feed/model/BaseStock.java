package com.company.gap.feed.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.company.gap.base.model.GeneralModel;

@MappedSuperclass
public class BaseStock extends GeneralModel {
	
	@Column(name="name_id", columnDefinition="int default 0")
	private Integer nameId;
	
	@Column(name="spec_id", columnDefinition="int default 0")
	private Integer specId;
	
	@Column(name="batch_id", columnDefinition="int default 0")
	private Integer batchId;
	
	@Column(name="producer_id", columnDefinition="int default 0")
	private Integer producerId;
	
	@Column(name="kind_id", columnDefinition="int default 0")
	private Integer kindId;
	
	@Column(columnDefinition="decimal(10,2) default 0")
	private Double quantity;

	public Integer getNameId() {
		return nameId;
	}

	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}
	
	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Integer getProducerId() {
		return producerId;
	}

	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}

	public Integer getKindId() {
		return kindId;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}