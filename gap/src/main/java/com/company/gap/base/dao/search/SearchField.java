package com.company.gap.base.dao.search;

import org.apache.commons.lang3.StringUtils;

public class SearchField implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	String		name;
	Op			op;
	String		value;
	String		value2;
	String[]	values;

	public SearchField() {
		this.op = Op.EQ.clone();
	}

	public SearchField(String name, Op op, String value) {
		this.name = name;
		this.op = op;
		this.value = value;
	}
	
	public String toString(){
		return new StringBuilder()
		
			.append(this.name).append(" ")
			.append(this.op.getName()).append(" ")
			.append(this.value).append(" ")
			.append(StringUtils.defaultString(this.value2, ""))
			
			.toString();
	}
	
	//
	// //////////////////////////////////////////
	//   getters & setters
	// 

	public String getName() {
		return name;
	}
	public Op getOp() {
		return op;
	}
	public String getValue() {
		return value == null ? null : value.trim();
	}
	public String getValue2() {
		return value2 == null ? null : value2.trim();
	}
	public String[] getValues() {
		return values;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOp(Op op) {
		this.op = op;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public void setValues(String[] values) {
		this.values = values;
	}
}