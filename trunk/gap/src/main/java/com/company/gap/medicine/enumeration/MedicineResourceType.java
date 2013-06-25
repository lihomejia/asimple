package com.company.gap.medicine.enumeration;


public enum MedicineResourceType {
	
	PM("兽药品名维护", "兽药品名"),
	
	GG("兽药规格维护", "兽药规格"),
	
	SCPH("兽药生产批号维护", "兽药生产批号"),
	
	SCS("兽药生产商维护", "兽药生产商"), 
	
	ZL("兽药种类维护", "兽药种类");
	
	private String title;
	private String name;
	MedicineResourceType(String title, String name) {
		this.title = title;
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	public String getName() {
		return name;
	}
}