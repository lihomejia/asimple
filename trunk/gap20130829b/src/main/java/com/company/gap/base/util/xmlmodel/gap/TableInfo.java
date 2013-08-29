package com.company.gap.base.util.xmlmodel.gap;

import com.company.util.xmlmodel.Attribute;
import com.company.util.xmlmodel.TextNode;

public class TableInfo extends TableElement {

	public void addRow(String field, String value) {
		TrElement tr = new TrElement();
		this.addChild(tr);

		{
			TdElement td = new TdElement();
			tr.addChild(td);
			td.addAttribute(new Attribute("class", "title"));
			td.addChild(new TextNode(field));
		}
		{
			TdElement td = new TdElement();
			tr.addChild(td);
			td.addChild(new TextNode(value));
		}
	}
}
