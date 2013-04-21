package com.company.gap.grow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.company.gap.base.model.GeneralModel;

@MappedSuperclass
public class Input extends GeneralModel {
	@Column(name="register_id", columnDefinition="int default 0")
	private Integer registerId;
	
	@Column(name="cell_id", columnDefinition="int default 0")
	private Integer cellId;
	
	@Column(name="name_id", columnDefinition="int default 0")
	private Integer nameId;
	
	@Column(name="stock_id", columnDefinition="int default 0")
	private Integer stockId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date usedate;
	
	@Column(length=100)
	private String reason;
	
	@Column(columnDefinition="decimal(10,2) default 0")
	private Double useqty;
	
	@Column(length=100)
	private String machinecate;
	
	@Column(length=100)
	private String method;
	
	@Column(columnDefinition="decimal(10,2) default 0")
	private Double isolation;
	
	@Column(length=60)
	private String useperson;
	
	@Column(length=60)
	private String tech;

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

	public Integer getNameId() {
		return nameId;
	}

	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Date getUsedate() {
		return usedate;
	}

	public void setUsedate(Date usedate) {
		this.usedate = usedate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Double getUseqty() {
		return useqty;
	}

	public void setUseqty(Double useqty) {
		this.useqty = useqty;
	}

	public String getMachinecate() {
		return machinecate;
	}

	public void setMachinecate(String machinecate) {
		this.machinecate = machinecate;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Double getIsolation() {
		return isolation;
	}

	public void setIsolation(Double isolation) {
		this.isolation = isolation;
	}

	public String getUseperson() {
		return useperson;
	}

	public void setUseperson(String useperson) {
		this.useperson = useperson;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}
}
