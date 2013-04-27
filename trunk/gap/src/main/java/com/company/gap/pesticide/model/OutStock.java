package com.company.gap.pesticide.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="t_pesticide_outstock")
public class OutStock extends BaseStock {
	@Column(name="stock_id", columnDefinition="int default 0")
	private Integer stockId;
	
	@Column(name="register_id", columnDefinition="int default 0")
	private Integer registerId;
	
	@Column(name="cell_id", columnDefinition="int default 0")
	private Integer cellId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date outdate;
	
	@Column(name="outuser_id", columnDefinition="int default 0")
	private Integer outuserId;
	
	@Column(length=255)
	private String comment;

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getCellId() {
		return cellId;
	}

	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public Integer getOutuserId() {
		return outuserId;
	}

	public void setOutuserId(Integer outuserId) {
		this.outuserId = outuserId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}