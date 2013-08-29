package com.company.gap.feed.enumeration;


public enum FeedResourceType {
	
	PM("饲料品名维护", "饲料品名"),
	
	GG("饲料规格维护", "饲料规格"),
	
	SCPH("饲料生产批号维护", "饲料生产批号"),
	
	SCS("饲料生产商维护", "饲料生产商"), 
	
	ZL("饲料种类维护", "饲料种类");
	
	private String title;
	private String name;
	FeedResourceType(String title, String name) {
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