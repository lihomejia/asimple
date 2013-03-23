package com.company.gap.manure.enumeration;


public enum ManureInStockStatus {
	UNAUDITED(0, "未审核"),
	
	AUDITED(1, "已审核");
	
	private int status;
	private String name;
	ManureInStockStatus(int status, String name) {
		this.status = status;
		this.name = name;
	}
	
	public static ManureInStockStatus valueOf(int status) {
		switch (status) {
			case 0 : return UNAUDITED;
			case 1 : return AUDITED;
			default: return UNAUDITED;
		}
	}
	
	public int getStatus() {
		return status;
	}
	public String getName() {
		return name;
	}
}

