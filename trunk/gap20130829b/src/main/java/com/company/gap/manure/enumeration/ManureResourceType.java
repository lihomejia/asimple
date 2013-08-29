package com.company.gap.manure.enumeration;


public enum ManureResourceType {
	
	PM("肥料品名维护", "肥料品名"),
	
	GG("肥料规格维护", "肥料规格"),
	
	SCPH("肥料生产批号维护", "肥料生产批号"),
	
	SCS("肥料生产商维护", "肥料生产商"), 
	
	ZL("肥料种类维护", "肥料种类");
	
	private String title;
	private String name;
	ManureResourceType(String title, String name) {
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