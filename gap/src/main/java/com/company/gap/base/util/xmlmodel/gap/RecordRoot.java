package com.company.gap.base.util.xmlmodel.gap;

import com.company.util.xmlmodel.Attribute;
import com.company.util.xmlmodel.TextNode;

public class RecordRoot extends TableElement {

	public void addChild(String title, TableElement tableElement) {
		{
			TrElement tr = new TrElement();
			this.addChild(tr);
			TdElement td = new TdElement();
			tr.addChild(td);
			td.addAttribute(new Attribute("class", "sub1"));
			td.addChild(new TextNode(title));
		}
		{
			TrElement tr = new TrElement();
			this.addChild(tr);
			TdElement td = new TdElement();
			tr.addChild(td);
			td.addChild(tableElement);
		}
	}
}
