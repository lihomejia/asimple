package com.company.gap.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.IBeanViewDao;


@Repository
public class BeanViewDaoImpl<T> implements IBeanViewDao<T> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<T> queryList(String sql, Object[] pros, Class<T> cls) {
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(cls), pros);
	}

	@Override
	public int getCount(String sql, Object[] pros) {
		return jdbcTemplate.queryForInt(sql, pros);
	}
}