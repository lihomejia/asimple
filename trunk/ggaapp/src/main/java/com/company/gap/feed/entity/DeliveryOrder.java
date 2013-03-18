package com.company.gap.feed.entity;

public class DeliveryOrder {
	private String id;
	private String rsid;
	private String spid;
	private String batchid;
	private String producerid;
	private String typeid;
	private String useObject;
	private String deliveryDate;
	private int quantity;
	private String operator;
	private int status;
	private String remark;
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
	public String getUseObject() {
		return useObject;
	}
	public void setUseObject(String useObject) {
		this.useObject = useObject;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
