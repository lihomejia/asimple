package com.company.gap.base.controller;

import javax.servlet.http.HttpServletRequest;

import com.company.gap.base.util.FieldPropertyConvert;

public class BaseController implements ControllerSupport {
	protected String _action;
	
	protected String BASE_URL = "baseURL";
	
	protected String getActionPath(HttpServletRequest request) {
		return request.getRequestURI().toString().replaceFirst("\\w+\\.html.*", "");
	}
	
	protected String getRedirect(HttpServletRequest request) {
		return "redirect:" + request.getContextPath();
	}
	
	protected String toField(String property) {
		return FieldPropertyConvert.propertyToField(property);
	}
	
	protected String toProperty(String field) {
		return FieldPropertyConvert.fieldToProperty(field);
	}
}
