package com.company.gap.base.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.SimpleSearcher;

public interface IViewService {
	
	List<Map<String, Object>> queryList(SimpleSearcher searcher, Pager pager);
}