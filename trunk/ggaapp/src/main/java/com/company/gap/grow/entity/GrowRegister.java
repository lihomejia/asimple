package com.company.gap.grow.entity;

public class GrowRegister {
	private int register_id;
	private int register_cellid;
	private String register_person;
	private String register_regdate;
	private String register_desc;
	private int register_status;
	private String register_comment;
	
	public int getRegister_id() {
		return register_id;
	}
	public void setRegister_id(int register_id) {
		this.register_id = register_id;
	}
	public int getRegister_cellid() {
		return register_cellid;
	}
	public void setRegister_cellid(int register_cellid) {
		this.register_cellid = register_cellid;
	}
	public String getRegister_person() {
		return register_person;
	}
	public void setRegister_person(String register_person) {
		this.register_person = register_person;
	}
	public String getRegister_regdate() {
		return register_regdate;
	}
	public void setRegister_regdate(String register_regdate) {
		this.register_regdate = register_regdate;
	}
	public String getRegister_desc() {
		return register_desc;
	}
	public void setRegister_desc(String register_desc) {
		this.register_desc = register_desc;
	}
	public int getRegister_status() {
		return register_status;
	}
	public void setRegister_status(int register_status) {
		this.register_status = register_status;
	}
	public String getRegister_comment() {
		return register_comment;
	}
	public void setRegister_comment(String register_comment) {
		this.register_comment = register_comment;
	}
}