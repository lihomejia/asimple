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

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.KeyHolder;

import com.norming.ess.common.dao.CommonDao;

public class CommonDaoImpl extends JdbcTemplate implements CommonDao {
	
	public <T> List<T> query(String sql, Class<T> clazz) throws DataAccessException {
		return query(sql, new BeanPropertyRowMapper<T>(clazz));
	}
	
	public <T> List<T> query(String sql, Object[] args, Class<T> clazz) throws DataAccessException {
		return query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}
	
	public int[] batchInsert(final String[] sql) throws DataAccessException {
		return batchUpdate(sql);
	}
	
	public int[] batchInsert(String sql, final BatchPreparedStatementSetter pss) throws DataAccessException {
		return batchUpdate(sql, pss);
	}
	
	public int[] batchInsert(String sql, List<Object[]> batchArgs) {
		return batchUpdate(sql, batchArgs);
	}

	public int insert(String sql) throws DataAccessException {
		return update(sql);
	}
	
	public int insert(String sql, Object... args) throws DataAccessException {
		return update(sql, args);
	}

	public int insert(String sql, Object[] args, int[] argTypes) throws DataAccessException {
		return update(sql, args, argTypes);
	}
	
	public int insert(PreparedStatementCreator psc) throws DataAccessException {
		return update(psc);
	}

	public int insert(final PreparedStatementCreator psc, final KeyHolder generatedKeyHolder)
			throws DataAccessException {
		return update(psc, generatedKeyHolder);
	}

	public int insert(String sql, PreparedStatementSetter pss) throws DataAccessException {
		return update(sql, pss);
	}

	public int delete(String sql) throws DataAccessException {
		return update(sql);
	}
	
	public int delete(String sql, Object... args) throws DataAccessException {
		return update(sql, args);
	}
}