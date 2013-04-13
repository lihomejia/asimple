package com.company.gap.base.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.company.gap.base.util.BaseDto;
import com.company.gap.base.util.Dto;

@MappedSuperclass
public class GeneralModel {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private Dto  __added = new BaseDto();

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

	public Dto get__added() {
		return __added;
	}

	public void set__added(Dto __added) {
		this.__added = __added;
	}
}