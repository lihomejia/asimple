package com.company.gap.base.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.model.GeneralModel;
import com.company.gap.base.model.GeneralModelUtil;
import com.company.gap.base.util.sql.SqlResult;


public class BaseDaoImpl<T extends GeneralModel> implements IBaseDao<T> {
	
	/** Primary JdtcTemplate, default by dynamic datasource*/
	@Resource(name="jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	
	protected Class<T> clazz;
	protected String tableName;
	
	
	protected JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			if (types != null && types.length > 0){
				this.clazz = (Class<T>) types[0];
				this.tableName = GeneralModelUtil.getTableName(this.clazz);
			}
		}
	}
	
	@Override
	public int insert(T t) {
		t.setCdate(new Date());
		return GeneralModelUtil.insert(getJdbcTemplate(), t);
	}

	@Override
	public int update(T t) {
		return GeneralModelUtil.update(getJdbcTemplate(), t);
	}
	
	@Override
	public int deleteById(Integer id) {
		String sql = "delete from " + tableName + " where id=?";
		return getJdbcTemplate().update(sql, id);
	}
	
	@Override
	public int updateStatus(Integer id, Integer status) {
		String sql = "update " + tableName + " set status=? where id=?";
		return getJdbcTemplate().update(sql, status, id);
	}
	
	@Override
	public int updateStatus(Integer id, Integer status, Integer auserId, Date adate) {
		String sql = "update " + tableName + " set status=?,auser_id=?,adate=? where id=?";
		return getJdbcTemplate().update(sql, status, auserId, adate, id);
	}
	
	@Override
	public List<T> findList() {
		return this.findList("select * from " + tableName);
	}

	@Override
	public List<T> findList(String sql, Object... args) {
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(clazz), args);
	}
	
	@Override
	public List<T> findList(T t) {
		SqlResult result = GeneralModelUtil.getSelectSql(t);
		return this.findList(result.getSql(), result.getValues());
	}
	
	@Override
	public T findById(Integer id) {
		String sql = "select * from " + tableName + " where id=?";
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

	public String getTableName() {
		return tableName;
	}
}