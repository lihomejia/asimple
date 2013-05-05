package com.company.util.xmlmodel;

import java.util.List;


public interface IElement extends INode {
	String getTagName();
	
	List<INode> children();
	
	List<Attribute> attributes();
}
