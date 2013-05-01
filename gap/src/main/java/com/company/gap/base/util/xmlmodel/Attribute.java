package com.company.gap.base.util.xmlmodel;

public class Attribute implements INode {
	private String name;
	
	private String value;
	

	public Attribute(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Override
	public void writer(StringBuilder sb) {
		sb.append(" ").append(XmlUtil.attributeName(name)).append("=\"").append(XmlUtil.attributeValue(value)).append("\"");
	}

}
