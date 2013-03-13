package com.company.gap.base.dao.search;

/**
 * searcher定义,查询条件和翻页条件的组合.
 * 
 * @author fangzeyu
 *
 */
public interface Searcher {
	
	Pager getPager();
	
	void setPager(Pager pager);
	
	/** DESC */
	public static String ORDER_DESC = "DESC";
	/** ASC */
	public static String ORDER_ASC = "ASC";
	/** 1 = DESC */
	public static String ORDER_DESC2 = "1";
	/** 0 = ASC */
	public static String ORDER_ASC2 = "0";
	

}
