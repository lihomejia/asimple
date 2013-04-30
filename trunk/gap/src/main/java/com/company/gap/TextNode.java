package com.company.gap;

public class TextNode implements INode {

	private String text;
	
	
	public TextNode(String text) {
		super();
		this.text = text;
	}


	@Override
	public void writerXml(StringBuilder sb) {
		sb.append(XmlUtil.text(text));
	}

}
