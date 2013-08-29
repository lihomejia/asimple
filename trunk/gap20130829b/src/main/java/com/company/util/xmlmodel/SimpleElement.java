package com.company.util.xmlmodel;

public class SimpleElement extends AbstractElement {

	public SimpleElement(String tagName, String text) {
		super(tagName);
		
		this.addChild(new TextNode(text));
	}
	
}
