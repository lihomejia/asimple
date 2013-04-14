package com.company.gap.grow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_grow_register")
public class Register extends GeneralModel {
	@Column(name="cell_id", columnDefinition="int default 0")
	private Integer cellId;
	
	@Column(name="reguser_id", columnDefinition="int default 0")
	private Integer reguserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	
	@Column(length=100)
	private String description;
	
	@Column(length=36)
	private String person;
	
	@Column(columnDefinition="int default 0")
	private Integer growstatus;
	
	@Column(length=255)
	private String comment;

	public Integer getCellId() {
		return cellId;
	}

	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}

	public Integer getReguserId() {
		return reguserId;
	}

	public void setReguserId(Integer reguserId) {
		this.reguserId = reguserId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Integer getGrowstatus() {
		return growstatus;
	}

	public void setGrowstatus(Integer growstatus) {
		this.growstatus = growstatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}