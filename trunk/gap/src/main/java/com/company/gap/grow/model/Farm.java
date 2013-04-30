package com.company.gap.grow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_grow_farm")
public class Farm extends GeneralModel {
	@Column(name="register_id", columnDefinition="int default 0")
	private Integer registerId;
	
	@Column(name="cell_id", columnDefinition="int default 0")
	private Integer cellId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date activitydate;
	
	@Column(length=255)
	private String content;
	
	@Column(columnDefinition="decimal(10, 2) default 0")
	private Double scale;
	
	@Column(columnDefinition="int default 0")
	private Integer persons;
	
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

	public Date getActivitydate() {
		return activitydate;
	}

	public void setActivitydate(Date activitydate) {
		this.activitydate = activitydate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public Integer getPersons() {
		return persons;
	}

	public void setPersons(Integer persons) {
		this.persons = persons;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}