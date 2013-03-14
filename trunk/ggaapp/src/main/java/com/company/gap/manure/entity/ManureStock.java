package com.company.gap.manure.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ManureStock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int mastockId;
	private BigDecimal mastockTotqty;
	private BigDecimal mastockUsedqty;
	private BigDecimal mastockBalqty;
	private String mastockNote;
	
	
	public int getMastockId() {
		return mastockId;
	}
	public void setMastockId(int mastockId) {
		this.mastockId = mastockId;
	}
	public BigDecimal getMastockTotqty() {
		return mastockTotqty;
	}
	public void setMastockTotqty(BigDecimal mastockTotqty) {
		this.mastockTotqty = mastockTotqty;
	}
	public BigDecimal getMastockUsedqty() {
		return mastockUsedqty;
	}
	public void setMastockUsedqty(BigDecimal mastockUsedqty) {
		this.mastockUsedqty = mastockUsedqty;
	}
	public BigDecimal getMastockBalqty() {
		return mastockBalqty;
	}
	public void setMastockBalqty(BigDecimal mastockBalqty) {
		this.mastockBalqty = mastockBalqty;
	}
	public String getMastockNote() {
		return mastockNote;
	}
	public void setMastockNote(String mastockNote) {
		this.mastockNote = mastockNote;
	}
}