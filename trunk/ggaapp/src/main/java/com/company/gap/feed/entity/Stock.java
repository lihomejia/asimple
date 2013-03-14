package com.company.gap.feed.entity;

public class Stock {
	private String id;
	private String feedid;
	private int totalQuantity;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFeedid() {
		return feedid;
	}
	public void setFeedid(String feedid) {
		this.feedid = feedid;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
