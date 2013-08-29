package com.company.gap.grow.enumeration;


public enum ResourceType {
	
	KIND(1, "产品种类维护 ", "产品种类维");
	
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
