package com.company.gap.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IViewDao;
import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.Searcher;
import com.company.gap.base.service.IViewService;


@Service
public class ViewServiceImpl<T> implements IViewService<T> {

	@Autowired
	private IViewDao<T> viewDao;
	
	@Override
	public List<T> queryList(Searcher searcher) {
		
		Pager pager = searcher.getPager();
		
		List<T> datas = viewDao.queryList(searcher);
		
		pager.setHits(datas.size());
		pager.setAllhits(viewDao.getCount(searcher));
		pager.calculate();
		
		return (List<T>) datas;
	}
}