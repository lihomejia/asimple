package com.company.util.xmlmodel;


public class TextNode implements INode {

	private String text;
	
	
	public TextNode(String text) {
		super();
		this.text = text;
	}


	@Override
	public void writer(StringBuilder sb) {
		sb.append(XmlUtil.text(text));
	}

}
