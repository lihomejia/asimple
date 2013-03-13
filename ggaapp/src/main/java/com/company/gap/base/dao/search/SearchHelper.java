/**
 * 
 */
package com.company.gap.base.dao.search;

public class SearchHelper {

	
	/**
	 * 返回排序方式,如果是关键字desc或1,则认为是倒序,否则是顺序.
	 * 
	 * @param s
	 * @return
	 */
	public static String getOrderType(Object type){
		String stype = "" + type;
		return (stype.equalsIgnoreCase(Searcher.ORDER_DESC) || stype.equalsIgnoreCase(Searcher.ORDER_DESC2)) ? 
				Searcher.ORDER_DESC : Searcher.ORDER_ASC;
	}
}
