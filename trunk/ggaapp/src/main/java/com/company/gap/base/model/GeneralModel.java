package com.company.gap.base.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public class GeneralModel {

	@Id
	private Integer 	id;
	
	@Column(name="cuser_id", columnDefinition="int default 0")
	private Integer 	cuserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date 		cdate;
	
	@Column(columnDefinition="int default 0")
	private Integer     status;
	
	@Column(name="auser_id", columnDefinition="int default 0")
	private Integer	 	auserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date 		adate;
	
	@Transient
	private Map<String, Object>  __disp = new HashMap<String, Object>();

	@Override
	public String toString() {
		return GeneralModelUtil.toString(this);
	}

	//////////////////////////////////////////////////////
	//Getter && Setter
	//////////////////////////////////////////////////////
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCuserId() {
		return cuserId;
	}

	public void setCuserId(Integer cuserId) {
		this.cuserId = cuserId;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAuserId() {
		return auserId;
	}

	public void setAuserId(Integer auserId) {
		this.auserId = auserId;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public Map<String, Object> get__disp() {
		return __disp;
	}

	public void set__disp(Map<String, Object> __disp) {
		this.__disp = __disp;
	}
}