package com.company.gap.base.dao.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

public class SimpleSearcher extends BaseSearcher {
	
	private Map<String, SearchField>	sfs		= new HashMap<String, SearchField>();
	private Map<String, SearchField>	sfso	= new HashMap<String, SearchField>();
	private List<String[]>				orders	= new ArrayList<String[]>();
	private String 						select  = "";
	private String						group	= "";
	private String						addsql	= "";
	private String 						table	= "";
	private Integer						c		= 0;

	
	/**
	 * 添加一个查询域
	 * 
	 * @param sf, 一个SearchField
	 * @return 当前searcher
	 */
	public SimpleSearcher addSf(SearchField sf){		
		return addSfOnField(sf);
	}

	/**
	 * 添加一个查询域.
	 * 
	 * @param name
	 * @param op
	 * @param value
	 * @return 当前searcher
	 * @see #addSf(String, Op, String, int)
	 */
	public SimpleSearcher addSf(String name, Op op, String value){
		return addSf(new SearchField(name, op, value));
	}
	
	
	/**
	 * 添加查询条件,如果条件中的字段名称冲突,则覆盖.
	 * 
	 * @param sf
	 * @return
	 */
	public SimpleSearcher addSfOnField(SearchField sf){
		if (isUsefulSf(sf)){
			sfs.put(sf.getName(), sf);
		}
		return this;
	}
	
	
	/**
	 * 添加一个查询域
	 * 
	 * @param sf, 一个SearchField
	 * @return 当前searcher
	 */
	public SimpleSearcher addSf2(SearchField sf){		
		if (isUsefulSf(sf)){
			c++;
			sfs.put("f" + c , sf);
		}
		return this;
	}

	/**
	 * 添加一个查询域.
	 * 
	 * @param name
	 * @param op
	 * @param value
	 * @return 当前searcher
	 * @see #addSf(String, Op, String, int)
	 */
	public SimpleSearcher addSf2(String name, Op op, String value){
		return addSf2(new SearchField(name, op, value));
	}

	
	/**
	 * 删除搜索器中针对这些字段的搜索.
	 * 
	 * @param fieldname
	 * @return .
	 */
	public SimpleSearcher removeOnField(String fieldname){
		List<String> ls = new ArrayList<String>();
		for (Entry<String, SearchField> ent : sfs.entrySet()){
			if (ent.getValue().getName().equals(fieldname)){
				ls.add(ent.getKey());
			}
		}
		for (Object o : ls){
			sfs.remove(o);
		}
		
		return this;
	}
	
	/**
	 * 清除搜索器中的字段搜索信息,不会清除pager信息.
	 * 
	 * @return
	 */
	public SimpleSearcher clear(){
		this.sfs 	= new HashMap<String, SearchField>();
		this.sfso 	= new HashMap<String, SearchField>();
		this.orders = new ArrayList<String[]>();
		this.group 	= "";
		this.table	= "";
		this.c 		= 0;
		return this;
	}
	/**
	 * 清除搜索器重的排序信息,不会清除其它信息.
	 * @param fieldname
	 * @return
	 */
	public SimpleSearcher ordersClear(){
		orders = new ArrayList<String[]>();
		return this;
	}
	
	public SimpleSearcher addOrder(String fieldname){
		return addOrder(fieldname, Searcher.ORDER_ASC);
	}
	
	public SimpleSearcher addOrder(String fieldname, String order){
		boolean f = false;
		for (String[] ord : orders){
			if (fieldname.equals(ord[0])){
				ord[1] = order;
				f = true;
			}
		}
		if (!f){
			orders.add(new String[]{fieldname, order});
		}
		
		return this;
	}
	
	public SimpleSearcher addGroup(String group){
		this.group = group;
		return this;
	}
	
	public String calOrderBy(){
		List<String> arr = new ArrayList<String>();
		
		for (String[] ord : orders){
			arr.add(ord[0] + " " + ord[1]);
		}
		
		return StringUtils.join(arr, ", ");
	}
	
	/**
	 * 判断一个SearchField对象是否有效,
	 * 
	 * @param sf
	 * @return
	 */
	public static boolean isUsefulSf(SearchField sf){
		
		return 
			// 前三个判断是无效数据判断,
			sf != null &&
			sf.getOp() != null && 
			!StringUtils.isEmpty(sf.getName()) && 
			// 如果是BT操作符,则起码有一个值不为空.
			!(Op.BT.equals(sf.getOp()) && StringUtils.isEmpty(sf.getValue()) && StringUtils.isEmpty(sf.getValue2())) &&
			// 其它任何操作符,都要求value不能为空.
			!StringUtils.isEmpty(sf.getValue())
		;
	}

	public Map<String, SearchField> getSfs() {
		return sfs;
	}

	public void setSfs(Map<String, SearchField> sfs) {
		this.sfs = sfs;
	}

	public Map<String, SearchField> getSfso() {
		return sfso;
	}

	public void setSfso(Map<String, SearchField> sfso) {
		this.sfso = sfso;
	}

	public String getGroup() {
		return group;
	}

	public String getAddsql() {
		return addsql;
	}

	public void setAddsql(String addsql) {
		this.addsql = addsql;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public List<String[]> getOrders() {
		return orders;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}
}