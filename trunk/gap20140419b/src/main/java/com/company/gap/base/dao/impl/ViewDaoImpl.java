package com.company.gap.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.IViewDao;
import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;


@Repository
public class ViewDaoImpl implements IViewDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Dto> queryList(String sql, Object[] pros) {
		return jdbcTemplate.query(sql, new ColumnDtoRowMapper(), pros);
	}

	@Override
	public int getCount(String sql, Object[] pros) {
		return jdbcTemplate.queryForObject(sql, pros, Integer.class);
	}
}