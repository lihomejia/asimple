package com.company.gap.base.dao.search;


public class BaseSearcher implements Searcher {

	protected Pager pager;
	protected String tablename;
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public String getTablename() {
		return this.tablename;
	}
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}
