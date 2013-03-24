package com.company.gap.pesticide.enumeration;


public enum PesticideInStockStatus {
	UNAUDITED(0, "未审核"),
	
	AUDITED(1, "已审核"),
	
	NULLIFY(2, "已作废");
	
	private int status;
	private String name;
	PesticideInStockStatus(int status, String name) {
		this.status = status;
		this.name = name;
	}
	
	public static PesticideInStockStatus valueOf(int status) {
		switch (status) {
			case 0 : return UNAUDITED;
			case 1 : return AUDITED;
			case 2 : return NULLIFY;
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

