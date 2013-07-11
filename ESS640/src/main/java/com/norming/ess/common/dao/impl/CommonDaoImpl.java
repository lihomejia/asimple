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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.norming.ess.common.dao.CommonDao;
import com.norming.ess.common.jdbc.DomainRowMapper;
@SuppressWarnings("deprecation")

public class CommonDaoImpl extends JdbcDaoSupport implements CommonDao {

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#batchDataInfo(java.lang.String[])
	 */
	public String batch(String[] finalSql) {
		
		String loggerInfo = "";
		try {
			logger.info("batchUpdateMethod:" + finalSql);
			this.getJdbcTemplate().batchUpdate(finalSql);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("batchUpdateMethod:" + finalSql);
		}
		
		return loggerInfo;
	}
	
	/* (non-Javadoc)  
	 * @see com.norming.ess.common.dao.CommonDao#batchDataInfo(java.lang.String, org.springframework.jdbc.core.BatchPreparedStatementSetter)  
	 */
	public String batch(String sql,BatchPreparedStatementSetter psSetter) {
		
		String loggerInfo = "";
		try {
			logger.info("batchUpdateMethod:" + sql);
			this.getJdbcTemplate().batchUpdate(sql,psSetter);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("batchUpdateMethod:" + sql);
		}
		
		return loggerInfo;
	}
	
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#delDataInfoById(java.lang.String)
	 */
	
	public String delete(String finalSql) {
		
		String loggerInfo = "";
		try {
			logger.info("delDateInfoMethod:" + finalSql);
			this.getJdbcTemplate().execute(finalSql);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("delDateInfoMethod:" + finalSql);
		}
		return loggerInfo;
	}
	
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#findDataCount(java.lang.String)
	 */
	public int findCount(String finalSql) {
		
		int dataCount = 0;
		try {
			logger.info("findDataCountMethod:" + finalSql);
			dataCount = this.getJdbcTemplate().queryForInt(finalSql);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataCountMethod:" + finalSql);  
		}
		return dataCount;
	}

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#findDataJson(java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List<?> findJson(String finalSql, Class<?> clazz) {
		
		List<?> jsonList = null;
		try {
			logger.info("findDataJsonMethod:" + finalSql);
			jsonList = (List<?>) this.getJdbcTemplate().query(finalSql,new DomainRowMapper(clazz));		
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataJsonMethod:" + finalSql);
		}
		return jsonList;
	}

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#findObjectData(java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object findForObject(String finalSql, Class<?> clazz) {
		Object object = null;
		try {
			logger.info("findDataObject:" + finalSql);
			object = this.getJdbcTemplate().queryForObject(finalSql,new DomainRowMapper(clazz));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataObject:" + finalSql);
		}
		return object;
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findObject(java.lang.String, java.lang.Object[], org.springframework.jdbc.core.RowMapper)
	 */
	@SuppressWarnings("unchecked")
	public Object findForObject(String finalSql, Object[] objects,RowMapper rowMapper) {
		Object object = null;
		try {
			logger.info("获得数据对象信息:" + finalSql);
			object = this.getJdbcTemplate().queryForObject(finalSql, objects, rowMapper);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("获得数据对象信息:" + finalSql);
		}
		return object;
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findObject(java.lang.String, org.springframework.jdbc.core.RowMapper)
	 */
	@SuppressWarnings("unchecked")
	public Object findForObject(String finalSql, RowMapper rowMapper) {
		Object object = null;
		try {
			logger.info("获得数据对象信息:" + finalSql);
			object = this.getJdbcTemplate().queryForObject(finalSql, rowMapper);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("获得数据对象信息:" + finalSql);
		}
		return object;
	}
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#insertDataInfo(java.lang.String)
	 */
	public String insert(String finalSql) {
		String loggerInfo = "";
		try {
			logger.info("insertDataInfoForStrSqlMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("insertDataInfoForStrSqlMethod:" + finalSql);
		}
		
		return loggerInfo;
	}

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#insertDataInfo(java.lang.String, java.lang.Object[])
	 */
	public String insert(String finalSql, Object[] object) {
		String loggerInfo = "";
		try {
			logger.info("insertDataInfoForObjectMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql, object);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("insertDataInfoForObjectMethod:" + finalSql);
		}
		return loggerInfo;
	}

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#updateDataInfo(java.lang.String)
	 */
	public String update(String finalSql) {
		String loggerInfo = "";
		try {
			logger.info("updateDateInfoForStrSqlMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("updateDateInfoForStrSqlMethod:" + finalSql);
		}
		return loggerInfo;
	}

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#updateDataInfo(java.lang.String, java.lang.Object[])
	 */
	public String update(String finalSql, Object[] object) {
		String loggerInfo = "";
		try {
			logger.info("updateDateInfoForObjectMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql, object);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("updateDateInfoForObjectMethod:" + finalSql);
		}
		return loggerInfo;
	}

	
	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.CommonDao#findDataMap(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Map findMap(String finalSql) {
		Map map = null;
		try {
			logger.info("findDataMapMethod:" + finalSql);
			map = (Map) this.getJdbcTemplate().queryForMap(finalSql);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataMapMethod:" + finalSql);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.CommonDao#findDataList(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql) {
		List list = null;
		try {
			logger.info("findDataMapMethod:" + finalSql);
			list =  (List) this.getJdbcTemplate().queryForList(finalSql);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataMapMethod:" + finalSql);
		}

		return list;
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findList(java.lang.String, org.springframework.jdbc.core.RowMapper)
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,RowMapper rowMapper) {
		List list = null;
		try {
			logger.info("findDataList:" + finalSql);
			list =  (List) this.getJdbcTemplate().query(finalSql, rowMapper);			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataList:" + finalSql);
		}
		return list;
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findList(java.lang.String,java.lang.Object[],org.springframework.jdbc.core.RowMapper)
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,Object[] objects,RowMapper rowMapper) {
		List list = null;
		try {
			logger.info("findDataList:" + finalSql);
			list =  (List) this.getJdbcTemplate().query(finalSql, objects, rowMapper);			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataList:" + finalSql);
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.com.norming.framework.common.dao.CommonDao#delDataInfoById(java.lang.String, java.lang.Object[])
	 */
	public String delete(String finalSql, Object[] object) {
		String loggerInfo = "";
		try {
			logger.info("delDateInfoMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql, object);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("delDateInfoMethod:" + finalSql);
		}
		return loggerInfo;
	}

	
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateDataForInt(java.lang.String)
	 */
	public int updateForInt(String finalSql) {
		int updateCount = 0;
		try {
			logger.info("updateDateInfoForStrSqlMethod:" + finalSql);
			updateCount = this.getJdbcTemplate().update(finalSql);
		} catch (Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
			logger.debug("updateDateInfoForStrSqlMethod:" + finalSql);
		}
		return updateCount;
	}

	
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateDataForInt(java.lang.String, java.lang.Object[])
	 */
	public int updateForInt(String finalSql, Object[] object) {
		int updateCount = 0;
		try {
			logger.info("updateDateInfoForObjectMethod:" + finalSql);
			updateCount = this.getJdbcTemplate().update(finalSql, object);
		} catch (Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
			logger.debug("updateDateInfoForObjectMethod:" + finalSql);
		}
		return updateCount;
	}

	
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findDataMap(java.lang.String, java.lang.Object[])
	 */
	
	@SuppressWarnings("unchecked")
	public Map findMap(String finalSql, Object[] object) {
		Map map = null;
		try {
			logger.info("findDataMapMethod:" + finalSql);
			map = (Map) this.getJdbcTemplate().queryForMap(finalSql, object);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataMapMethod:" + finalSql);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findDataList(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql, Object[] object) {
		List list = null;
		try {
			logger.info("findDataMapMethod:" + finalSql);
			list =  (List) this.getJdbcTemplate().queryForList(finalSql, object);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataMapMethod:" + finalSql);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findDataCount(java.lang.String, java.lang.Object[])
	 */
	public int findCount(String finalSql, Object[] object) {
		int dataCount = 0;
		try {
			logger.info("findDataCountMethod:" + finalSql);
			dataCount = this.getJdbcTemplate().queryForInt(finalSql,object);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataCountMethod:" + finalSql);  
		}
		return dataCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForLong(java.lang.String)
	 */
	public long findForLong(String finalSql) {
		long dataCount = 0;
		try {
			logger.info("findForLongMethod:" + finalSql);
			dataCount = this.getJdbcTemplate().queryForLong(finalSql);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForLongMethod:" + finalSql);  
		}
		return dataCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForLong(java.lang.String, java.lang.Object[])
	 */
	public long findForLong(String finalSql, Object[] object) {
		long dataCount = 0;
		try {
			logger.info("findForLongMethod:" + finalSql);
			dataCount = this.getJdbcTemplate().queryForLong(finalSql, object);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForLongMethod:" + finalSql);  
		}
		return dataCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForLong(java.lang.String, java.lang.Object[], int[])
	 */
	public long findForLong(String finalSql, Object[] object, int[] argTypes) {
		long dataCount = 0;
		try {
			logger.info("findForLongMethod:" + finalSql);
			dataCount = this.getJdbcTemplate().queryForLong(finalSql, object, argTypes);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForLongMethod:" + finalSql);  
		}
		return dataCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForObject(java.lang.String, java.lang.Object[], int[], java.lang.Class)
	 */
	public Object findForObject(String finalSql, Object[] objects,int[] argTypes, Class<?> clazz) {
		Object object = null;
		try {
			logger.info("findForLongMethod:" + finalSql);
			object = this.getJdbcTemplate().queryForObject(finalSql, objects, argTypes, clazz);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForLongMethod:" + finalSql);  
		}
		return object;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForObject(java.lang.String, java.lang.Object[], int[], org.springframework.jdbc.core.RowMapper)
	 */
	@SuppressWarnings("unchecked")
	public Object findForObject(String finalSql, Object[] objects,int[] argTypes, RowMapper rowMapper) {
		Object object = null;
		try {
			logger.info("findForLongMethod:" + finalSql);
			object = this.getJdbcTemplate().queryForObject(finalSql, objects, argTypes, rowMapper);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForLongMethod:" + finalSql);  
		}
		return object;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForList(java.lang.String, java.lang.Object[], java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql, Object[] objects, Class<?> clazz) {
		List list = null;
		try {
			logger.info("findDataMapMethod:" + finalSql);
			list =  (List) this.getJdbcTemplate().queryForList(finalSql, objects, clazz);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataMapMethod:" + finalSql);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForList(java.lang.String, java.lang.Object[], int[])
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql, Object[] objects, int[] argTypes) {
		List list = null;
		try {
			logger.info("findDataMapMethod:" + finalSql);
			list =  (List) this.getJdbcTemplate().queryForList(finalSql, objects, argTypes);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataMapMethod:" + finalSql);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForList(java.lang.String, java.lang.Object[], int[], java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql, Object[] objects, int[] argTypes, Class<?> clazz) {
		List list = null;
		try {
			logger.info("findDataMapMethod:" + finalSql);
			list =  (List) this.getJdbcTemplate().queryForList(finalSql, objects, argTypes, clazz);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findDataMapMethod:" + finalSql);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findMap(java.lang.String, java.lang.Object[], int[])
	 */
	@SuppressWarnings("unchecked")
	public Map findMap(String finalSql, Object[] object, int[] argTyes) {
		Map map = null;
		try {
			logger.info("findMapMethod:" + finalSql);
			map = (Map) this.getJdbcTemplate().queryForMap(finalSql, object, argTyes);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findMapMethod:" + finalSql);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForRowSet(java.lang.String)
	 */
	public SqlRowSet findForRowSet(String finalSql) {
		SqlRowSet sqlRS = null;
		try {
			logger.info("findForRowSetMethod:" + finalSql);
			sqlRS = this.getJdbcTemplate().queryForRowSet(finalSql);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForRowSetMethod:" + finalSql);
		}
		return sqlRS;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForRowSet(java.lang.String, java.lang.Object[])
	 */
	public SqlRowSet findForRowSet(String finalSql, Object[] object) {
		SqlRowSet sqlRS = null;
		try {
			logger.info("findForRowSetMethod:" + finalSql);
			sqlRS = this.getJdbcTemplate().queryForRowSet(finalSql , object);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForRowSetMethod:" + finalSql);
		}
		return sqlRS;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#findForRowSet(java.lang.String, java.lang.Object[], int[])
	 */
	public SqlRowSet findForRowSet(String finalSql, Object[] object, int[] argTypes) {
		SqlRowSet sqlRS = null;
		try {
			logger.info("findForRowSetMethod:" + finalSql);
			sqlRS = this.getJdbcTemplate().queryForRowSet(finalSql , object , argTypes);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("findForRowSetMethod:" + finalSql);
		}
		return sqlRS;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#update(java.lang.String, java.lang.Object[], int[])
	 */
	public String update(String finalSql, Object[] object, int[] argsTypes) {
		String loggerInfo = "";
		try {
			logger.info("updateMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql , object , argsTypes);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("updateMethod:" + finalSql);
		}
		return loggerInfo;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#update(java.lang.String, org.springframework.jdbc.core.BatchPreparedStatementSetter)
	 */
	public String update(String finalSql,BatchPreparedStatementSetter batchPreparedStatementSetter) {
		String loggerInfo = "";
		try {
			logger.info("updateMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql , batchPreparedStatementSetter);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("updateMethod:" + finalSql);
		}
		return loggerInfo;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateForInt(org.springframework.jdbc.core.PreparedStatementCreator, org.springframework.jdbc.support.KeyHolder)
	 */
	public int updateForInt(PreparedStatementCreator preparedStatementCreator,KeyHolder generatedKeyHolder) {
		int updateCount = 0;
		try {
			logger.info("updateForIntMethod:");
			updateCount = this.getJdbcTemplate().update(preparedStatementCreator, generatedKeyHolder);
		} catch (Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
			logger.debug("updateForIntMethod:" + updateCount);
		}
		return updateCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#updateForInt(java.lang.String, org.springframework.jdbc.core.PreparedStatementSetter)
	 */
	public int updateForInt(String finalSql,PreparedStatementSetter preparedStatementSetter) {
		int updateCount = 0;
		try {
			logger.info("updateForIntMethod:"+finalSql);
			updateCount = this.getJdbcTemplate().update(finalSql, preparedStatementSetter);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("updateForIntMethod:" + ex.getMessage());
		}
		return updateCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#delete(java.lang.String, java.lang.Object[], int[])
	 */
	public String delete(String finalSql, Object[] object, int[] argsTypes) {
		String loggerInfo = "";
		try {
			logger.info("delDateInfoMethod:" + finalSql);
			this.getJdbcTemplate().update(finalSql, object ,argsTypes);
		} catch (Exception ex) {
			loggerInfo = ex.getMessage();
			ex.printStackTrace();
			logger.debug("delDateInfoMethod:" + finalSql);
		}
		return loggerInfo;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#deleteForInt(java.lang.String)
	 */
	public int deleteForInt(String finalSql) {
		int delCount = 0;
		try {
			logger.info("deleteForIntMethod:"+finalSql);
			delCount = this.getJdbcTemplate().update(finalSql);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("deleteForIntMethod:" + ex.getMessage());
		}
		return delCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#deleteForInt(java.lang.String, java.lang.Object[])
	 */
	public int deleteForInt(String finalSql, Object[] object) {
		int delCount = 0;
		try {
			logger.info("deleteForIntMethod:"+finalSql);
			delCount = this.getJdbcTemplate().update(finalSql ,object);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("deleteForIntMethod:" + ex.getMessage());
		}
		return delCount;
	}

	/* (non-Javadoc)
	 * 
	 * 
	 * @see com.norming.ess.common.dao.CommonDao#deleteForInt(java.lang.String, org.springframework.jdbc.core.PreparedStatementSetter)
	 */
	public int deleteForInt(String finalSql,PreparedStatementSetter preparedStatementSetter) {
		int delCount = 0;
		try {
			logger.info("deleteForIntMethod:"+finalSql);
			delCount = this.getJdbcTemplate().update(finalSql ,preparedStatementSetter);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("deleteForIntMethod:" + ex.getMessage());
		}
		return delCount;
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#insert(java.lang.String, org.springframework.jdbc.core.PreparedStatementSetter)
	 */
	public int insertForInt(String finalSql,PreparedStatementSetter preparedStatementSetter) {
		int insertCount = 0;
		try {
			logger.info("insertMethod:"+finalSql);
			insertCount = this.getJdbcTemplate().update(finalSql ,preparedStatementSetter);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("insertMethod:" + ex.getMessage());
		}
		return insertCount;
	}

	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#insertForInt(java.lang.String)
	 */
	public int insertForInt(String finalSql) {
		int insertCount = 0;
		try {
			logger.info("insertMethod:"+finalSql);
			insertCount = this.getJdbcTemplate().update(finalSql);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("insertMethod:" + ex.getMessage());
		}
		return insertCount;
	}
	/* (non-Javadoc)
	 * @see com.norming.ess.common.dao.CommonDao#insertForInt(java.lang.String, java.lang.Object[])
	 */
	public int insertForInt(String finalSql, Object[] object) {
		int insertCount = 0;
		try {
			logger.info("insertMethod:"+finalSql);
			insertCount = this.getJdbcTemplate().update(finalSql ,object);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("insertMethod:" + ex.getMessage());
		}
		return insertCount;
	}
}
