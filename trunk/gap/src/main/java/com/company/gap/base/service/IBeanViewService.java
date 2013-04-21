package com.company.gap.base.service;

import java.util.List;

import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.SimpleSearcher;

public interface IBeanViewService<T> {
	
	List<T> queryList(SimpleSearcher searcher, Pager pager, Class<T> cls);
}