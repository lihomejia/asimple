package com.company.gap;

public class Test {

	
	public static void main(String[] args) {

		AbstractElement root = new AbstractElement("result");
		
		AbstractElement base = new AbstractElement("基本信息");
		
		
		base.addChild(new SimpleElement("产品编号", "笑嘻嘻"));
		
		root.addChild(base);
		
		base.addAttribute(new Attribute("abc", "123"));
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		root.writerXml(sb);
		
		System.out.println(sb);
		
		
		
	}

}
