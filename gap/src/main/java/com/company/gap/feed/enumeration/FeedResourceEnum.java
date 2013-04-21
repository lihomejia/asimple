package com.company.gap.feed.enumeration;

/**
 * 饲料资源
 * 
 * @author MING.XIN
 */
public enum FeedResourceEnum {
	NAME(1, "饲料品名维护", "饲料品名"),
	
	SPECIFICATION(2, "饲料规格维护", "饲料规格"),
	
	BATCH_NUMBER(3, "饲料生产批号维护", "饲料生产批号"),
	
	PRODUCER(4, "饲料生产商维护", "饲料生产商"), 
	
	TYPE(5, "饲料种类维护", "饲料种类");

	private int number;
	private String title;
	private String resourceName;

	private FeedResourceEnum(int number, String title, String resourceName) {
		this.number = number;
		this.title = title;
		this.resourceName = resourceName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public static FeedResourceEnum valueOf(int resourceNumber) {
		FeedResourceEnum[] feedResources = FeedResourceEnum.values();
		for(FeedResourceEnum feedResource : feedResources){
			if(feedResource.getNumber() == resourceNumber){
				return feedResource;
			}
		}
		return null;
	}
}
