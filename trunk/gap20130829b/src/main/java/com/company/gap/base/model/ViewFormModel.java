package com.company.gap.base.model;

import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.SimpleSearcher;

public class ViewFormModel extends FormModel {
	
	public ViewFormModel() {}
	
	private Pager pager;
	
	private SimpleSearcher searcher;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public SimpleSearcher getSearcher() {
		return searcher;
	}

	public void setSearcher(SimpleSearcher searcher) {
		this.searcher = searcher;
	}
}