package com.company.gap.base.util.xmlmodel;

import java.util.List;


public interface IElement extends INode {
	String getTagName();
	
	List<INode> children();
	
	List<Attribute> attributes();
}
