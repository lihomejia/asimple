package com.company.gap.manure.enumeration;

public enum ManureResourceType {
	NAME(1),
	SIZE(2),
	BATCH(3),
	PRODUCER(4),
	KIND(5);
	
	private int type;
	ManureResourceType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
}
