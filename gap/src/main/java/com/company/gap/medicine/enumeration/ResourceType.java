package com.company.gap.medicine.enumeration;


public enum ResourceType {
	
	NAME(1, "兽药品名维护", "兽药品名"),
	
	SPEC(2, "兽药规格维护", "兽药规格"),
	
	BATCH(3, "兽药生产批号维护", "兽药生产批号"),
	
	PRODUCER(4, "兽药生产商维护", "兽药生产商"), 
	
	KIND(5, "兽药种类维护", "兽药种类");
	
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
