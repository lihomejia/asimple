package com.company.gap.base.dao;

import java.util.List;

import com.company.gap.base.dao.search.Searcher;

public interface IViewDao<T> {

	List<T> queryList(Searcher searcher);
	
	int getCount(Searcher searcher);
}
