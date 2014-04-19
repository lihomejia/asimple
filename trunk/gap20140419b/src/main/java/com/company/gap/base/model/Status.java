package com.company.gap.base.model;


public enum Status {
	
	WAITING(0, "待审批"),
	
	APPROVED(2, "已批准"),
	
	NULLIFY(3, "已作废");
	
	
	private int status;
	private String name;
	
	Status(int status, String name) {
		this.status = status;
		this.name = name;
	}
	
	public static Status valueOf(int status) {
		switch (status) {
			case 0 : return WAITING;
			case 2 : return APPROVED;
			case 3 : return NULLIFY;
			default: return WAITING;
		}
	}

	public int getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}
}
