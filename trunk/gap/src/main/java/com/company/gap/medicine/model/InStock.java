package com.company.gap.medicine.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="t_medicine_instock")
public class InStock extends BaseStock {
	@Column(name="stock_id", columnDefinition="int default 0")
	private Integer stockId;
	
	@Column(length=60)
	private String location;
	
	@Column(length=60)
	private String element;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date indate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirydate;
	
	@Column(length=60)
	private String vendor;
	
	@Column(length=60)
	private String wrap;
	
	@Column(name="inuser_id", columnDefinition="int default 0")
	private Integer inuserId;
	
	@Column(length=255)
	private String comment;

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getWrap() {
		return wrap;
	}

	public void setWrap(String wrap) {
		this.wrap = wrap;
	}

	public Integer getInuserId() {
		return inuserId;
	}

	public void setInuserId(Integer inuserId) {
		this.inuserId = inuserId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}