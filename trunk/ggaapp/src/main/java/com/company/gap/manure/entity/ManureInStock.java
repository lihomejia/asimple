package com.company.gap.manure.entity;


public class ManureInStock {
	
	private int instock_id;
	private int instock_stockid;
	private int instock_nameid;
	private int instock_sizeid;
	private int instock_batchid;
	private int instock_producerid;
	private Double instock_quantity;
	private int instock_status;
	private String instock_location;
	private String instock_element;
	private String instock_indate;
	private int instock_kindid;
	private String instock_expirydate;
	private String instock_vendor;
	private String instock_wrap;
	private String instock_inmanager;
	private String instock_comment;
	
	public ManureStock getStock() {
		ManureStock stock = new ManureStock();
		stock.setStock_nameid(this.instock_nameid);
		stock.setStock_sizeid(this.instock_sizeid);
		stock.setStock_batchid(this.instock_batchid);
		stock.setStock_producerid(this.instock_producerid);
		stock.setStock_quantity(this.instock_quantity);
		return stock;
	}
	
	public int getInstock_id() {
		return instock_id;
	}
	public void setInstock_id(int instock_id) {
		this.instock_id = instock_id;
	}
	public int getInstock_stockid() {
		return instock_stockid;
	}
	public void setInstock_stockid(int instock_stockid) {
		this.instock_stockid = instock_stockid;
	}
	public int getInstock_nameid() {
		return instock_nameid;
	}
	public void setInstock_nameid(int instock_nameid) {
		this.instock_nameid = instock_nameid;
	}
	public int getInstock_sizeid() {
		return instock_sizeid;
	}
	public void setInstock_sizeid(int instock_sizeid) {
		this.instock_sizeid = instock_sizeid;
	}
	public int getInstock_batchid() {
		return instock_batchid;
	}
	public void setInstock_batchid(int instock_batchid) {
		this.instock_batchid = instock_batchid;
	}
	public int getInstock_producerid() {
		return instock_producerid;
	}
	public void setInstock_producerid(int instock_producerid) {
		this.instock_producerid = instock_producerid;
	}
	public Double getInstock_quantity() {
		return instock_quantity;
	}
	public void setInstock_quantity(Double instock_quantity) {
		this.instock_quantity = instock_quantity;
	}
	public int getInstock_status() {
		return instock_status;
	}
	public void setInstock_status(int instock_status) {
		this.instock_status = instock_status;
	}
	public String getInstock_location() {
		return instock_location;
	}
	public void setInstock_location(String instock_location) {
		this.instock_location = instock_location;
	}
	public String getInstock_element() {
		return instock_element;
	}
	public void setInstock_element(String instock_element) {
		this.instock_element = instock_element;
	}
	public String getInstock_indate() {
		return instock_indate;
	}
	public void setInstock_indate(String instock_indate) {
		this.instock_indate = instock_indate;
	}
	public int getInstock_kindid() {
		return instock_kindid;
	}
	public void setInstock_kindid(int instock_kindid) {
		this.instock_kindid = instock_kindid;
	}
	public String getInstock_expirydate() {
		return instock_expirydate;
	}
	public void setInstock_expirydate(String instock_expirydate) {
		this.instock_expirydate = instock_expirydate;
	}
	public String getInstock_vendor() {
		return instock_vendor;
	}
	public void setInstock_vendor(String instock_vendor) {
		this.instock_vendor = instock_vendor;
	}
	public String getInstock_wrap() {
		return instock_wrap;
	}
	public void setInstock_wrap(String instock_wrap) {
		this.instock_wrap = instock_wrap;
	}
	public String getInstock_inmanager() {
		return instock_inmanager;
	}
	public void setInstock_inmanager(String instock_inmanager) {
		this.instock_inmanager = instock_inmanager;
	}
	public String getInstock_comment() {
		return instock_comment;
	}
	public void setInstock_comment(String instock_comment) {
		this.instock_comment = instock_comment;
	}
}