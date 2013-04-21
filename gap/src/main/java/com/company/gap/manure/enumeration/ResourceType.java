package com.company.gap.manure.enumeration;


public enum ResourceType {
	
	NAME(1, "肥料品名维护", "肥料品名"),
	
	SPEC(2, "肥料规格维护", "肥料规格"),
	
	BATCH(3, "肥料生产批号维护", "肥料生产批号"),
	
	PRODUCER(4, "肥料生产商维护", "肥料生产商"), 
	
	KIND(5, "肥料种类维护", "肥料种类");
	
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
