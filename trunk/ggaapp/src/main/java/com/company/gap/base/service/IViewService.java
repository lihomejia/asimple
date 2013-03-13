package com.company.gap.base.service;

import java.util.List;

import com.company.gap.base.dao.search.Searcher;

public interface IViewService {
	
	<T> List<T> queryList(Searcher searcher);
}
