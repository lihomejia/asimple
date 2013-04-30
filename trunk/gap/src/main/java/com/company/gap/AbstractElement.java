package com.company.gap;

import java.util.ArrayList;
import java.util.List;

public class AbstractElement implements INode, IElement {

	private String tagName;
	
	private List<INode> children;
	
	private List<Attribute> attributes;
	
	
	public AbstractElement(String tagName) {
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
	public void writerXml(StringBuilder sb) {
		sb.append("<").append(XmlUtil.tagName(getTagName()));
		
		for (Attribute attribute : attributes) {
			attribute.writerXml(sb);
		}
		
		sb.append(">");
		
		for (INode node : children()) {
			node.writerXml(sb);
		}
		
		sb.append("</").append(XmlUtil.tagName(getTagName())).append(">");
	}
	
	public AbstractElement addChild(INode node) {
		children.add(node);
		return this;
	}
	
	public AbstractElement addAttribute(Attribute attribute) {
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
