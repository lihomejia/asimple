package com.company.gap.base.entity;

import java.util.HashMap;
import java.util.Map;

public class FormModel {
	private Map<String, Object> pars = new HashMap<String, Object>();
	
	private Map<String, Object> data = new HashMap<String, Object>();

	public Map<String, Object> getPars() {
		return pars;
	}

	public void setPars(Map<String, Object> pars) {
		this.pars = pars;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
}
