/**
 * Copyright (C) Norming Information Technology Co.,Ltd. 2012. All 
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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.norming.ess.common.dao.CommonDao;
import com.norming.ess.common.jdbc.DomainRowMapper;

public class CommonDaoImpl extends JdbcDaoSupport implements CommonDao {

	/* (non-Javadoc)
	 * @see cn.com.norming.core.db.dao.ICommonDao#batchDataInfo(java.lang.String[])
	 */
	public String batchDataInfo(String[] finalSql) {
		
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
	
	/** (non-Javadoc)  
	 * @see com.norming.ess.common.dao.CommonDao#batchDataInfo(java.lang.String, org.springframework.jdbc.core.BatchPreparedStatementSetter)  
	 */
	public String batchDataInfo(String sql,BatchPreparedStatementSetter psSetter) {
		
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
	
	public String delDataInfoById(String finalSql) {
		
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
	public int findDataCount(String finalSql) {
		
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
	public List<?> findDataJson(String finalSql, Class<?> clazz) {
		
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
	public Object findObjectData(String finalSql, Class<?> clazz) {
		Object object = null;
		try {
			logger.info("获得数据对象信息:" + finalSql);
			object = this.getJdbcTemplate().queryForObject(finalSql,new DomainRowMapper(clazz));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("获得数据对象信息:" + finalSql);
		}
		return object;
	}
	public Object findObjectData(String finalSql, Object[] objects,RowMapper rowMapper) {
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
	public Object findObjectData(String finalSql, RowMapper rowMapper) {
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
	public String insertDataInfo(String finalSql) {
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
	public String insertDataInfo(String finalSql, Object[] object) {
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
	public String updateDataInfo(String finalSql) {
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
	public String updateDataInfo(String finalSql, Object[] object) {
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
	public Map findDataMap(String finalSql) {
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
	public List findDataList(String finalSql) {
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
	@SuppressWarnings("unchecked")
	public List findDataList(String finalSql,RowMapper rowMapper) {
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
	@SuppressWarnings("unchecked")
	public List findDataList(String finalSql,Object[] objects,RowMapper rowMapper) {
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
	public String delDataInfoById(String finalSql, Object[] object) {
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
	public int updateDataForInt(String finalSql) {
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
	public int updateDataForInt(String finalSql, Object[] object) {
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
	public Map findDataMap(String finalSql, Object[] object) {
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
	public List findDataList(String finalSql, Object[] object) {
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
	public int findDataCount(String finalSql, Object[] object) {
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
	
}
