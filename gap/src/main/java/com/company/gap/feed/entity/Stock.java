package com.company.gap.feed.entity;

public class Stock {
	private String id;
	private String rsid;
	private String spid;
	private String batchid;
	private String producerid;
	private String typeid;
	private int totalQuantity;
	private String updatetime;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRsid() {
		return rsid;
	}
	public void setRsid(String rsid) {
		this.rsid = rsid;
	}
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getProducerid() {
		return producerid;
	}
	public void setProducerid(String producerid) {
		this.producerid = producerid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
