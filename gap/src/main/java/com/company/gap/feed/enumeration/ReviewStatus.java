package com.company.gap.feed.enumeration;

public enum ReviewStatus {
	
	/**未审核*/
	UNAUDITED(1),
	/**已通过*/
	PASSED(2);
	
	private ReviewStatus(int number) {
		this.number = number;
	}
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
