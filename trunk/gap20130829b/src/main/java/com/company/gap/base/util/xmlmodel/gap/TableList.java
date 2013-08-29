package com.company.gap.base.util.xmlmodel.gap;

import com.company.util.xmlmodel.Attribute;


public class TableList extends TableElement {
	
	public void addChild(TableInfo tableInfo) {
		if (!children().isEmpty()) {
			TrElement tr = new TrElement();
			this.addChild(tr);
			
			TdElement td = new TdElement();
			tr.addChild(td);
			td.addAttribute(new Attribute("class", "liner"));
			
		}
		TrElement tr = new TrElement();
		this.addChild(tr);
		
		TdElement td = new TdElement();
		tr.addChild(td);
		td.addChild(tableInfo);
	}
}