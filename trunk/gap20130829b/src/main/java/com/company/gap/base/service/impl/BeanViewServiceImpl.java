package com.company.gap.base.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBeanViewDao;
import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.SearcherAnalysis;
import com.company.gap.base.dao.search.SimpleSearcher;
import com.company.gap.base.service.IBeanViewService;
import com.company.gap.base.util.sql.SqlResult;
import com.company.gap.base.util.sql.SqlUtils;


@Service
public class BeanViewServiceImpl<T> implements IBeanViewService<T> {

	@Autowired
	private IBeanViewDao<T> viewDao;
	
	@Override
	public List<T> queryList(SimpleSearcher searcher, Pager pager, Class<T> cls) {
		SimpleSearcher ss = (SimpleSearcher) searcher;

		String from 	= " from " + ss.getTable();
		SqlResult where = SearcherAnalysis.getWhereFromSimpleSearcher(ss);
		String select 	= SearcherAnalysis.getSelectFromSimpleSearcher(ss); 
		String group 	= SearcherAnalysis.getGroupByFromSimpleSearcher(ss);
		String order 	= SearcherAnalysis.getOrderByFromSimpleSearcher(ss);
		
		String sql = select + from + where.getSql() + group + order;
		sql = SqlUtils.toPagerSql(sql, pager.getStart(), pager.getCount());
		
		String csql = "select count(*) " + from + where.getSql();
		if (!StringUtils.isEmpty(group)) {
			csql = "select count(*) from (select 1 " + from + where.getSql() + group + ") t ";
		}
		
		List<T> datas = viewDao.queryList(sql, where.getValues(), cls);
		
		pager.setHits(datas.size());
		pager.setAllhits(viewDao.getCount(csql, where.getValues()));
		pager.calculate();
		
		return datas;
	}
}