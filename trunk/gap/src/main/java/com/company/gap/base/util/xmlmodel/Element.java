package com.company.gap.base.util.xmlmodel;


public class Element extends AbstractElement {

	protected Element(String tagName) {
		super(tagName);
	}

	@Override
	public AbstractElement addChild(INode node) {
		return super.addChild(node);
	}

	@Override
	public AbstractElement addAttribute(Attribute attribute) {
		return super.addAttribute(attribute);
	}
}
