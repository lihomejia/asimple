package com.company.gap.feed.entity;

public class FeedResource {
	private String id;
	private String name;
	private int type;
	public FeedResource() {
	}
	public FeedResource(String id, String name, int type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
