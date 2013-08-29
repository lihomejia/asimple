package com.company.gap.base.service;

import java.util.List;

import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.SimpleSearcher;
import com.company.gap.base.util.Dto;

public interface IViewService {
	
	List<Dto> queryList(SimpleSearcher searcher, Pager pager);
}