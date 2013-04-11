package com.company.gap.cell.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.company.gap.base.model.GeneralModel;

@Entity
@Table(name="t_production_cell")
public class Cell extends GeneralModel {
	private String code;
	private String location;
	private Double area;
	private Integer useStatus;
	private Date buildDate;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public Integer getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}
	public Date getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	
}