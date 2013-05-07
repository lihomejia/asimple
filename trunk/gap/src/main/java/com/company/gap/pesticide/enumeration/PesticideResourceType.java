package com.company.gap.pesticide.enumeration;


public enum PesticideResourceType {
	
	PM("农药品名维护", "农药品名"),
	
	GG("农药规格维护", "农药规格"),
	
	SCPH("农药生产批号维护", "农药生产批号"),
	
	SCS("农药生产商维护", "农药生产商"), 
	
	ZL("农药种类维护", "农药种类");
	
	private String title;
	private String name;
	PesticideResourceType(String title, String name) {
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