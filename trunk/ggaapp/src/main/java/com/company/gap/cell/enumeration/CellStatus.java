package com.company.gap.cell.enumeration;


public enum CellStatus {
	IDLE(0, "空闲"),
	OCCUPY(1, "占用");
	
	private int status;
	private String name;
	
	CellStatus(int status, String name) {
		this.status = status;
		this.name = name;
	}
	
	public static CellStatus valueOf(int status) {
		switch (status) {
			case 0 : return IDLE;
			case 1 : return OCCUPY;
			default: return IDLE;
		}
	}

	public int getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}
}
