package com.company.gap.base.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.IViewDao;
import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.Searcher;


@Repository
public class ViewDaoImpl<T> implements IViewDao<T> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<T> queryList(Searcher searcher) {
		Pager pager = searcher.getPager();
		String sql = "select * from " + searcher.getTablename() + " limit " + (pager.getStart()-1) + ",20";
		
		Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(entityClass));
		
	}
	
	

	@Override
	public int getCount(Searcher searcher) {
		return jdbcTemplate.queryForInt("select count(*) from " + searcher.getTablename());
	}

}
