package com.company.gap.disinfectant.enumeration;


public enum DisinfectantResourceType {
	
	PM("消毒剂品名维护", "消毒剂品名"),
	
	GG("消毒剂规格维护", "消毒剂规格"),
	
	SCPH("消毒剂生产批号维护", "消毒剂生产批号"),
	
	SCS("消毒剂生产商维护", "消毒剂生产商"), 
	
	ZL("消毒剂种类维护", "消毒剂种类");
	
	private String title;
	private String name;
	DisinfectantResourceType(String title, String name) {
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