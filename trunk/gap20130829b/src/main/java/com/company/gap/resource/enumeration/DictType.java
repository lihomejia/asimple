package com.company.gap.resource.enumeration;


public enum DictType {
	
	CPLB("产品类别维护", "产品类别"),
	
	JXLB("机械类别维护", "机械类别"),
	
	SYFF("使用方法维护", "使用方法"),
	
	SGFF("收割方法维护", "收割方法"), 
	
	GGFS("灌溉方式维护", "灌溉方式");
	
	private String title;
	private String name;
	
	DictType(String title, String name) {
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