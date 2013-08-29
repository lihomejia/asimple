package com.company.util.xmlmodel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractElement implements IElement {

private String tagName;
	
	private List<INode> children;
	
	private List<Attribute> attributes;
	
	
	protected AbstractElement(String tagName) {
		super();
		this.tagName = tagName;
		this.children = new ArrayList<INode>();
		this.attributes = new ArrayList<Attribute>();
	}
	

	@Override
	public List<Attribute> attributes() {
		return attributes;
	}
	

	@Override
	public void writer(StringBuilder sb) {
		sb.append("<").append(XmlUtil.tagName(getTagName()));
		
		for (Attribute attribute : attributes) {
			attribute.writer(sb);
		}
		
		sb.append(">");
		
		for (INode node : children()) {
			node.writer(sb);
		}
		
		sb.append("</").append(XmlUtil.tagName(getTagName())).append(">");
	}
	
	protected AbstractElement addChild(INode node) {
		children.add(node);
		return this;
	}
	
	protected AbstractElement addAttribute(Attribute attribute) {
		attributes.add(attribute);
		return this;
	}

	@Override
	public String getTagName() {
		return tagName;
	}

	@Override
	public List<INode> children() {
		return children;
	}
}