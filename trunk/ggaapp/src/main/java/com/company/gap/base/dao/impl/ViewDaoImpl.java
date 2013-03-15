package com.company.gap.base.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.IViewDao;


@Repository
public class ViewDaoImpl implements IViewDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> queryList(String sql, Object[] pros) {
		return jdbcTemplate.queryForList(sql, pros);
	}

	@Override
	public int getCount(String sql, Object[] pros) {
		return jdbcTemplate.queryForInt(sql, pros);
	}
}