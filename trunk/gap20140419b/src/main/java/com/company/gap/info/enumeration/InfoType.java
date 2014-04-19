package com.company.gap.info.enumeration;

public enum InfoType {
	
	TZGG("通知公告维护", "通知公告"),
	
	QYXXH("企业信息化维护", "企业信息化"),
	
	QYXW("企业新闻维护", "企业新闻");
	
	
	private String title;
	private String name;
	InfoType(String title, String name) {
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