package com.company.gap.nurture.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_nurture_irrigate")
public class Irrigate extends GeneralModel {
	@Column(name="register_id", columnDefinition="int default 0")
	private Integer registerId;
	
	@Column(name="cell_id", columnDefinition="int default 0")
	private Integer cellId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(length=30)
	private String way;
	
	@Column(columnDefinition="decimal(10,2) default 0")
	private Double area;
	
	@Column(columnDefinition="decimal(10,2) default 0")
	private Double quantum;
	
	@Column(length=60)
	private String manager;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getQuantum() {
		return quantum;
	}

	public void setQuantum(Double quantum) {
		this.quantum = quantum;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}