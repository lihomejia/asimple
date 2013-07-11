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
package com.norming.ess.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

/**
 * Norming持久层API公用服务接口类. 
 * @author LiRui
 * @date Jul 12, 2012
 * 
 * @edit Oct. 19,2012 增加对dataformater的依赖 
 * 
 * 任何持久层操作以及获取数据源的操作必须继承此类。不允许越过数据库连接池自行获取dataSource
 */
public interface CommonDao {
	
	String BEAN_NAME = "commonDao";
	String BEAN_DYNAMIC = "commonDaoDynamic";
	
	/**
	 * 	通过SQL返回查询的总数据条数 
	 * 
	 * @param String 型SQL.如：finalSql = "SELECT COUNT(*) FROM user";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return int型整数。总数据条数。
	 */
	public int findDataCount(String finalSql);
	/**
	 * 	通过SQL返回查询的总数据条数 
	 * 
	 * @param String 型SQL.如：finalSql = "SELECT COUNT(*) FROM user WHERE user_id=?";
	 * *@param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return int型整数。总数据条数。

	 */
	public int findDataCount(String finalSql,Object[] object);
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param object型对象.如：USER.class
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return List<E> 对象数组。 
	 */
	public List<?> findDataJson(String finalSql, Class<?> clazz);
	/**
	 * 	通过SQL返回查询对象的集合。Map
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return Map HashMap。
	 */
	@SuppressWarnings("unchecked")
	public Map findDataMap(String finalSql);
	/**
	 * 	通过SQL返回查询对象的集合。Map
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return Map HashMap。

	 */
	@SuppressWarnings("unchecked")
	public Map findDataMap(String finalSql,Object[] object);
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return List<E> 对象数组。
	 */
	@SuppressWarnings("unchecked")
	public List findDataList(String finalSql);
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Aug 24, 2012
	 * @return List<E> 对象数组。	 */
	@SuppressWarnings("unchecked")
	public List findDataList(String finalSql,Object[] object);
	
	/**
	 * @param finalSql
	 * @param rowMapper
	 * @return List 
	 * @author ys.wang
	 * @date Feb 2, 2013 
	 */
	@SuppressWarnings("unchecked")
	List findDataList(String finalSql,RowMapper rowMapper);
	
	/**
	 * 	通过SQL返回查询对象。
	 * 
	 * @param String型SQL.如：finalSql = "SELECT * FROM user WHERE user_id='01'";
	 * @param object型对象.如: USER.class
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return Object对象。
	 */
	public Object findObjectData(String finalSql, Class<?> clazz);
	
	/**通过SQL返回查询对象。
	 * @param finalSql
	 * @param objects
	 * @param rowMapper
	 * @return Object 
	 * @author ys.wang
	 * @date Jan 30, 2013 
	 */
	public Object findObjectData(String finalSql, Object[] objects,RowMapper rowMapper);
	/**
	 * 	通过SQL删除数据信息。(接口1)
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String delDataInfoById(String finalSql);
	/**
	 * 	通过SQL删除数据信息。（接口2）
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '?'";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String delDataInfoById(String finalSql ,Object[] object);
	/**
	 *  通过SQL添加数据信息（接口1）
	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES('','','')";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息.
	 */
	public String insertDataInfo(String finalSql);
	/**
	 *  通过SQL添加数据信息（接口2）
	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES(?,?,?)";
	 * @param object[]对象数组 如：new Object[] {'1','2','3'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String insertDataInfo(String finalSql, Object[] object);
	/**
	 * 通过SQL修改数据信息（接口1）
	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET name='1' WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String updateDataInfo(String finalSql);
	/**
	 *  通过SQL修改数据信息（接口2）
	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param object[]对象数组 如：new Object[] {'jack','20','0001'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String updateDataInfo(String finalSql, Object[] object);
	/**
	 * 通过SQL修改数据信息（接口3）

	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET name='1' WHERE user_id='01'";
	 * @author LiRui
	 * @date Aug 23, 2012
	 * @return int。

	 */
	public int updateDataForInt(String finalSql);
	/**
	 *  通过SQL修改数据信息（接口4）

	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param object[]对象数组 如：new Object[] {'jack','20','0001'}
	 * @author LiRui
	 * @date Aug 23, 2012
	 * @return int。

	 */
	public int updateDataForInt(String finalSql, Object[] object);
	/**
	 * 	通过SQL[] 批量处理数据。
	 * 
	 * @param String[]型SQL.如：finalSql.toArray(new String[finalSql.size()])
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String batchDataInfo(String[] finalSql);
	
	/**
	 * @param sql
	 * @param batchSize
	 * @param psSetter
	 * @return String 
	 * @author ys.wang
	 * @date Jan 28, 2013 
	 */
	String batchDataInfo(String sql,BatchPreparedStatementSetter psSetter);
	/**
	 * @param finalSql
	 * @param rowMapper
	 * @return Object 
	 * @author ys.wang
	 * @date Feb 21, 2013 
	 */
	Object findObjectData(String finalSql, RowMapper rowMapper); 
}
