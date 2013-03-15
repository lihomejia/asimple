package com.company.gap.base.dao.search;


public class BaseSearcher implements Searcher {

	protected Pager pager;
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
}