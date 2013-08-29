package com.company.gap.base.util.xmlmodel.gap;

public class Test123 {
	public static void main(String[] args) {

		RecordRoot root = new RecordRoot();

		{
			TableInfo baseInfo = new TableInfo();
			root.addChild("基本信息", baseInfo);

			baseInfo.addRow("序&nbsp;&nbsp;列&nbsp;&nbsp;号:", "gap-0123456789");
			baseInfo.addRow("产品名称:", "猕猴桃");
			baseInfo.addRow("生产厂家:", "北京世外桃源农业科技");
			baseInfo.addRow("生产日期:", "2013-03-06");
			baseInfo.addRow("出厂日期:", "2013-04-02");
		}
		{
			TableList tableList = new TableList();
			root.addChild("灌溉记录", tableList);
			{
				TableInfo rowInfo = new TableInfo();
				tableList.addChild(rowInfo);
				
				rowInfo.addRow("操作时间:", "2013-04-02");
				rowInfo.addRow("负&nbsp;&nbsp;责&nbsp;&nbsp;人:", "XXX");
				rowInfo.addRow("备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:", "北京局部地区有冰雹");
			}
			{
				TableInfo rowInfo = new TableInfo();
				tableList.addChild(rowInfo);
				
				rowInfo.addRow("操作时间:", "2013-04-02");
				rowInfo.addRow("负&nbsp;&nbsp;责&nbsp;&nbsp;人:", "XXX");
				rowInfo.addRow("备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:", "北京局部地区有冰雹");
			}
		}
		StringBuilder sb = new StringBuilder();
		
		root.writer(sb);
		
		System.out.println(sb);
		
	}
}