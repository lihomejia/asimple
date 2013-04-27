package com.company.gap.pesticide.enumeration;


public enum ResourceType {
	
	NAME(1, "农药品名维护", "农药品名"),
	
	SPEC(2, "农药规格维护", "农药规格"),
	
	BATCH(3, "农药生产批号维护", "农药生产批号"),
	
	PRODUCER(4, "农药生产商维护", "农药生产商"), 
	
	KIND(5, "农药种类维护", "农药种类");
	
	private int type;
	private String title;
	private String name;
	ResourceType(int type, String title, String name) {
		this.type = type;
		this.title = title;
		this.name = name;
	}
	
	public static ResourceType valueOf(int type) {
		ResourceType[] rss = ResourceType.values();
		for(ResourceType rs : rss){
			if(rs.getType() == type){
				return rs;
			}
		}
		return null;
	}
	
	public int getType() {
		return type;
	}
	public String getTitle() {
		return title;
	}
	public String getName() {
		return name;
	}
}
