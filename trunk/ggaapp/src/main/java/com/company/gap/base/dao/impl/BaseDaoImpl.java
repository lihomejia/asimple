package com.company.gap.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.model.GeneralModelUtil;
import com.company.gap.base.util.sql.SqlResult;


public class BaseDaoImpl<T> implements IBaseDao<T> {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	private Class<T> cls;
	private String tableName;
	
	public static String PRIMARYKEY = "id";
	
	public BaseDaoImpl(Class<T> cls) {
		this.cls = cls;
		this.tableName = GeneralModelUtil.getTableName(cls);
	}

	@Override
	public int insert(T t) {
		return GeneralModelUtil.insert(jdbcTemplate, t);
	}
	
	@Override
	public int insert2(T t) {
		return GeneralModelUtil.insert2(jdbcTemplate, t);
	}

	@Override
	public int update(T t) {
		return GeneralModelUtil.update(jdbcTemplate, t);
	}
	
	@Override
	public int deleteById(Integer id) {
		String sql = "delete from " + tableName + " where " + PRIMARYKEY + "=?";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public List<T> findList() {
		return this.findList("select * from " + tableName);
	}

	@Override
	public List<T> findList(String sql, Object... args) {
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(cls), args);
	}
	
	@Override
	public List<T> findList(T t) {
		SqlResult result = GeneralModelUtil.getSelectSql(t);
		return this.findList(result.getSql(), result.getValues());
	}
	
	@Override
	public T findById(Integer id) {
		String sql = "select * from " + tableName + " where " + PRIMARYKEY + "=?";
		return this.findBean(sql, id);
	}

	@Override
	public T findBean(T t) {
		SqlResult result = GeneralModelUtil.getSelectSql(t);
		return this.findBean(result.getSql(), result.getValues());
	}
	
	@Override
	public T findBean(String sql, Object... args) {
		List<T> list = this.findList(sql, args);
		if (list.size() > 0) return list.get(0);
		return null;
	}
}