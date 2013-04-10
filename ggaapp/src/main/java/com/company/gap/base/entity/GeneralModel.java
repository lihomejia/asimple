package com.company.gap.base.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.company.gap.base.annotation.Comment;

@Entity
@Comment("所有实体的基类")
public class GeneralModel {
	@Comment("主键")
	@Column(unique=true)
	private Integer 	id;
	
	@Comment("创建人ID")
	private Integer 	cuserId;
	
	@Comment("创建日期")
	private Date 		cdate;
	
	@Comment("审批人ID")
	private Integer	 	auserId;
	
	@Comment("审批日期")
	private Date 		adate;
	
	@Comment("存储各种其他信息的介质")
	private Map<String, Object>  __disp = new HashMap<String, Object>();

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