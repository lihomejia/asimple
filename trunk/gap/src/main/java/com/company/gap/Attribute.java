package com.company.gap;

public class Attribute implements INode {
	private String name;
	
	private String value;
	
	

	public Attribute(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}




	@Override
	public void writerXml(StringBuilder sb) {
		sb.append(" ").append(XmlUtil.attributeName(name)).append("=\"").append(XmlUtil.attributeValue(value)).append("\"");
	}

}
