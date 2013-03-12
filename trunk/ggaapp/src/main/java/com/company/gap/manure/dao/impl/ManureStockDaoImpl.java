package com.company.gap.manure.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.manure.dao.IManureStockDao;
import com.company.gap.manure.entity.ManureStock;

@Repository
public class ManureStockDaoImpl implements IManureStockDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ManureStock> queryList() {
		return jdbcTemplate.query("select * from MA_STOCK", new BeanPropertyRowMapper<ManureStock>(ManureStock.class));
	}
}
