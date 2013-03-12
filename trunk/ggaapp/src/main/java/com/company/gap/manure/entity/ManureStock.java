package com.company.gap.manure.entity;

import java.math.BigDecimal;

public class ManureStock {
	private int mastockId;
	private BigDecimal mastockTotqty;
	private BigDecimal mastockUsedqty;
	private BigDecimal mastockBalqty;
	
	
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
}