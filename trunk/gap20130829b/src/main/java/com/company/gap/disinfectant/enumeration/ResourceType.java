package com.company.gap.disinfectant.enumeration;


public enum ResourceType {
	
	NAME(1, "消毒剂品名维护", "消毒剂品名"),
	
	SPEC(2, "消毒剂规格维护", "消毒剂规格"),
	
	BATCH(3, "消毒剂生产批号维护", "消毒剂生产批号"),
	
	PRODUCER(4, "消毒剂生产商维护", "消毒剂生产商"), 
	
	KIND(5, "消毒剂种类维护", "消毒剂种类");
	
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
