package com.company.gap.base.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController implements ControllerSupport {
	protected String _action;
	
	protected String BASE_URL = "baseURL";
	
	protected String getActionPath(HttpServletRequest request) {
		return request.getRequestURL().toString().replaceFirst("\\w+\\.html.*", "");
	}
}
