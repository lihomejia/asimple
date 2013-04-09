package com.company.gap.base.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GeneralModel {
	private Integer 	id;
	private Integer 	cuser_id;
	private Date 		cdate;
	private Integer	 	auser_id;
	private Date 		adate;
	
	private Map<String, Object>  __disp = new HashMap<String, Object>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCuser_id() {
		return cuser_id;
	}
	public void setCuser_id(Integer cuser_id) {
		this.cuser_id = cuser_id;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Integer getAuser_id() {
		return auser_id;
	}
	public void setAuser_id(Integer auser_id) {
		this.auser_id = auser_id;
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
