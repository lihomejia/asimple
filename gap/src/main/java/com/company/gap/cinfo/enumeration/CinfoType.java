package com.company.gap.cinfo.enumeration;

public enum CinfoType {
	
	GSJJ("公司简介维护", "公司简介"),
	
	GSXW("公司新闻维护", "公司新闻"),
	
	CPFW("产品服务维护", "产品服务");
	
	private String title;
	private String name;
	CinfoType(String title, String name) {
		this.title = title;
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	public String getName() {
		return name;
	}
}