package com.company.gap.pesticide.entity;


public class PesticideResource {
	private int resource_id;
	private String resource_name;
	private int resource_type;
	
	public static PesticideResource ALL = new PesticideResource(0, "--全部--");
	
	public PesticideResource(){}
	
	public PesticideResource(int resource_id, String resource_name) {
		this.resource_id = resource_id;
		this.resource_name = resource_name;
	}
	public PesticideResource(int resource_id, String resource_name, int resource_type) {
		this.resource_id = resource_id;
		this.resource_name = resource_name;
		this.resource_type = resource_type;
	}
	public int getResource_id() {
		return resource_id;
	}
	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public int getResource_type() {
		return resource_type;
	}
	public void setResource_type(int resource_type) {
		this.resource_type = resource_type;
	}
}