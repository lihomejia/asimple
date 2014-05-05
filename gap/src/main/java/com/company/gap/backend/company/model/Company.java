package com.company.gap.backend.company.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_company")
public class Company extends GeneralModel {
	
	@Column(length=60)
	private String companyno;
	
	@Column(length=60)
	private String companyname;
	
	@Column(length=60)
	private String innercode;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date indate;
	
	@Column(columnDefinition="int default 0")
	private Integer type;
	
	public Company() {}
	
	public Company(String innercode) {
		this.innercode = innercode;
	}

	public String getCompanyno() {
		return companyno;
	}

	public void setCompanyno(String companyno) {
		this.companyno = companyno;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public String getInnercode() {
		return innercode;
	}

	public void setInnercode(String innercode) {
		this.innercode = innercode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

}