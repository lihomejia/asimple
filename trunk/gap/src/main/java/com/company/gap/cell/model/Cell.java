package com.company.gap.cell.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_production_cell")
public class Cell extends GeneralModel {
	
	private String code;//单元代码 
	
	private String location;//单元位置 
	
	@Column(columnDefinition="decimal(10,2) default 0")
	private Double area;//单元面积
	
	@Column(columnDefinition="int default 0")
	private Integer usestatus;//单元状态 
	
	private Date builddate;//建档日期 

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

	public Integer getUsestatus() {
		return usestatus;
	}

	public void setUsestatus(Integer usestatus) {
		this.usestatus = usestatus;
	}

	public Date getBuilddate() {
		return builddate;
	}

	public void setBuilddate(Date builddate) {
		this.builddate = builddate;
	}
}