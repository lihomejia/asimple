/**
 * Copyright (C) Norming Information Technology Co.,Ltd. 2013. All 
 * rights reserved.
 *
 * This software is covered by the license agreement between the end user and
 * Norming Information Technology Co.,LTD., and may be used and copied 
 * only in accordance with the terms of the said agreement.
 * 
 * Norming Information Science Co.,LTD. assumes no responsibility or 
 * liability for any errors or inaccuracies in this software, 
 * or any consequential, incidental or indirect damage arising out of the use 
 * of the software.
 */
package com.norming.ess.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.norming.ess.common.dao.CommonDao;

public class CommonDaoImpl extends JdbcDaoSupport implements CommonDao {

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#batchDataInfo(java.lang.String[])
	 */
	public int[] batch(String[] finalSql) {
		return this.getJdbcTemplate().batchUpdate(finalSql);
	}
	/* (non-Javadoc)  
	 * @see com.norming.ess.common.dao.CommonDao#batchDataInfo(java.lang.String, org.springframework.jdbc.core.BatchPreparedStatementSetter)  
	 */
	public int[] batch(String sql,BatchPreparedStatementSetter psSetter) {
		return this.getJdbcTemplate().batchUpdate(sql,psSetter);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#delDataInfoById(java.lang.String)
	 */
	public void delete(String finalSql) {
		this.getJdbcTemplate().execute(finalSql);;
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#findDataCount(java.lang.String)
	 */
	public int findCount(String finalSql) {
		return this.getJdbcTemplate().queryForInt(finalSql);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#findDataJson(java.lang.String, java.lang.Class)
	 */
	public <T> List<T> findJson(String finalSql, Class<T> clazz) {
		return this.getJdbcTemplate().query(finalSql,new BeanPropertyRowMapper<T>(clazz));
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#findObjectData(java.lang.String, java.lang.Class)
	 */
	public <T> T findForObject(String finalSql, Class<T> clazz) {
		return (T) this.getJdbcTemplate().queryForObject(finalSql,new BeanPropertyRowMapper<T>(clazz));
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findObject(java.lang.String, java.lang.Object[], org.springframework.jdbc.core.RowMapper)
	 */
	public <T> T findForObject(String finalSql, Object[] objects,RowMapper<T> rowMapper) {
		return this.getJdbcTemplate().queryForObject(finalSql, objects, rowMapper);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findObject(java.lang.String, org.springframework.jdbc.core.RowMapper)
	 */
	public <T> T findForObject(String finalSql, RowMapper<T> rowMapper) {
		return this.getJdbcTemplate().queryForObject(finalSql, rowMapper);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#insertDataInfo(java.lang.String)
	 */
	public void insert(String finalSql) {
		this.getJdbcTemplate().update(finalSql);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#insertDataInfo(java.lang.String, java.lang.Object[])
	 */
	public void insert(String finalSql, Object[] object) {
		this.getJdbcTemplate().update(finalSql, object);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#updateDataInfo(java.lang.String)
	 */
	public void update(String finalSql) {
		this.getJdbcTemplate().update(finalSql);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#updateDataInfo(java.lang.String, java.lang.Object[])
	 */
	public void update(String finalSql, Object[] object) {
		this.getJdbcTemplate().update(finalSql, object);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.CommonDao#findDataMap(java.lang.String)
	 */
	public Map<String,Object> findMap(String finalSql) {
		return this.getJdbcTemplate().queryForMap(finalSql);
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.CommonDao#findDataList(java.lang.String)
	 */
	public List<?> findForList(String finalSql) {
		return this.getJdbcTemplate().queryForList(finalSql);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findList(java.lang.String, org.springframework.jdbc.core.RowMapper)
	 */
	public List<?> findForList(String finalSql,RowMapper<?> rowMapper) {
		return this.getJdbcTemplate().query(finalSql, rowMapper);	
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findList(java.lang.String,java.lang.Object[],org.springframework.jdbc.core.RowMapper)
	 */
	public List<?> findForList(String finalSql,Object[] objects,RowMapper<?> rowMapper) {
		return this.getJdbcTemplate().query(finalSql, objects, rowMapper);
	}
	/* (non-Javadoc)
	 * @see java.com.norming.framework.common.dao.CommonDao#delDataInfoById(java.lang.String, java.lang.Object[])
	 */
	public void delete(String finalSql, Object[] object) {
		this.getJdbcTemplate().update(finalSql, object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateDataForInt(java.lang.String)
	 */
	public int updateForInt(String finalSql) {
		return this.getJdbcTemplate().update(finalSql);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateDataForInt(java.lang.String, java.lang.Object[])
	 */
	public int updateForInt(String finalSql, Object[] object) {
		return this.getJdbcTemplate().update(finalSql, object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findDataMap(java.lang.String, java.lang.Object[])
	 */
	public Map<String,Object> findMap(String finalSql, Object[] object) {
		return this.getJdbcTemplate().queryForMap(finalSql, object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findDataList(java.lang.String, java.lang.Object[])
	 */
	public List<?> findForList(String finalSql, Object[] object) {
		return this.getJdbcTemplate().queryForList(finalSql, object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findDataCount(java.lang.String, java.lang.Object[])
	 */
	public int findCount(String finalSql, Object[] object) {
		return this.getJdbcTemplate().queryForInt(finalSql,object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForLong(java.lang.String)
	 */
	public long findForLong(String finalSql) {
		return this.getJdbcTemplate().queryForLong(finalSql);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForLong(java.lang.String, java.lang.Object[])
	 */
	public long findForLong(String finalSql, Object[] object) {
		return this.getJdbcTemplate().queryForLong(finalSql, object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForLong(java.lang.String, java.lang.Object[], int[])
	 */
	public long findForLong(String finalSql, Object[] object, int[] argTypes) {
		return this.getJdbcTemplate().queryForLong(finalSql, object, argTypes);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForObject(java.lang.String, java.lang.Object[], int[], java.lang.Class)
	 */
	public <T> T findForObject(String finalSql, Object[] objects,int[] argTypes, Class<T> clazz) {
		return (T) this.getJdbcTemplate().queryForObject(finalSql, objects, argTypes, clazz);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForObject(java.lang.String, java.lang.Object[], int[], org.springframework.jdbc.core.RowMapper)
	 */
	public <T> T findForObject(String finalSql, Object[] objects,int[] argTypes, RowMapper<T> rowMapper) {
		return this.getJdbcTemplate().queryForObject(finalSql, objects, argTypes, rowMapper);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForList(java.lang.String, java.lang.Object[], java.lang.Class)
	 */
	public List<?> findForList(String finalSql, Object[] objects, Class<?> clazz) {
		return this.getJdbcTemplate().queryForList(finalSql, objects, clazz);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForList(java.lang.String, java.lang.Object[], int[])
	 */
	public List<?> findForList(String finalSql, Object[] objects, int[] argTypes) {
		return this.getJdbcTemplate().queryForList(finalSql, objects, argTypes);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForList(java.lang.String, java.lang.Object[], int[], java.lang.Class)
	 */
	public List<?> findForList(String finalSql, Object[] objects, int[] argTypes, Class<?> clazz) {
		return this.getJdbcTemplate().queryForList(finalSql, objects, argTypes, clazz);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findMap(java.lang.String, java.lang.Object[], int[])
	 */
	public Map<String,Object> findMap(String finalSql, Object[] object, int[] argTyes) {
		return this.getJdbcTemplate().queryForMap(finalSql, object, argTyes);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForRowSet(java.lang.String)
	 */
	public SqlRowSet findForRowSet(String finalSql) {
		return this.getJdbcTemplate().queryForRowSet(finalSql);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForRowSet(java.lang.String, java.lang.Object[])
	 */
	public SqlRowSet findForRowSet(String finalSql, Object[] object) {
		return this.getJdbcTemplate().queryForRowSet(finalSql , object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForRowSet(java.lang.String, java.lang.Object[], int[])
	 */
	public SqlRowSet findForRowSet(String finalSql, Object[] object, int[] argTypes) {
		return this.getJdbcTemplate().queryForRowSet(finalSql , object , argTypes);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#update(java.lang.String, java.lang.Object[], int[])
	 */
	public void update(String finalSql, Object[] object, int[] argsTypes) {
		this.getJdbcTemplate().update(finalSql , object , argsTypes);;
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#update(java.lang.String, org.springframework.jdbc.core.BatchPreparedStatementSetter)
	 */
	public void update(String finalSql,BatchPreparedStatementSetter batchPreparedStatementSetter) {
		this.getJdbcTemplate().update(finalSql , batchPreparedStatementSetter);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateForInt(org.springframework.jdbc.core.PreparedStatementCreator, org.springframework.jdbc.support.KeyHolder)
	 */
	public int updateForInt(PreparedStatementCreator preparedStatementCreator,KeyHolder generatedKeyHolder) {
		return this.getJdbcTemplate().update(preparedStatementCreator, generatedKeyHolder);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateForInt(java.lang.String, org.springframework.jdbc.core.PreparedStatementSetter)
	 */
	public int updateForInt(String finalSql,PreparedStatementSetter preparedStatementSetter) {
		return this.getJdbcTemplate().update(finalSql, preparedStatementSetter);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#delete(java.lang.String, java.lang.Object[], int[])
	 */
	public void delete(String finalSql, Object[] object, int[] argsTypes) {
		this.getJdbcTemplate().update(finalSql, object ,argsTypes);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#deleteForInt(java.lang.String)
	 */
	public int deleteForInt(String finalSql) {
		return this.getJdbcTemplate().update(finalSql);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#deleteForInt(java.lang.String, java.lang.Object[])
	 */
	public int deleteForInt(String finalSql, Object[] object) {
		return this.getJdbcTemplate().update(finalSql ,object);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#deleteForInt(java.lang.String, org.springframework.jdbc.core.PreparedStatementSetter)
	 */
	public int deleteForInt(String finalSql,PreparedStatementSetter preparedStatementSetter) {
		return this.getJdbcTemplate().update(finalSql ,preparedStatementSetter);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#insert(java.lang.String, org.springframework.jdbc.core.PreparedStatementSetter)
	 */
	public int insertForInt(String finalSql,PreparedStatementSetter preparedStatementSetter) {
		return this.getJdbcTemplate().update(finalSql ,preparedStatementSetter);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#insertForInt(java.lang.String)
	 */
	public int insertForInt(String finalSql) {
		return this.getJdbcTemplate().update(finalSql);
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#insertForInt(java.lang.String, java.lang.Object[])
	 */
	public int insertForInt(String finalSql, Object[] object) {
		return this.getJdbcTemplate().update(finalSql ,object);
	}
}
