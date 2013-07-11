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
package com.norming.ess.common.dao;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * Norming持久层API公用服务接口类.  2.0
 * @author LiRui
 * @date Jul 12, 2012
 * 
 * @edit June. 25,2013 去除Spring3废弃方法。并对新方法增强！并新增接口
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
	 * @return int型整数。总数据条数。	 */
	public int findCount(String finalSql);
	/**
	 * 	通过SQL返回查询的总数据条数 
	 * 
	 * @param String 型SQL.如：finalSql = "SELECT COUNT(*) FROM user WHERE user_id=?";
	 * *@param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return int型整数。总数据条数。	 */
	public int findCount(String finalSql,Object[] object);
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param object型对象.如：USER.class
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return List<E> 对象数组。 
	 */
	public List<?> findJson(String finalSql, Class<?> clazz);
	/**
	 * 	通过SQL返回查询对象的集合。Map
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return Map 	 */
	@SuppressWarnings("unchecked")
	public Map findMap(String finalSql);
	/**
	 * 	通过SQL返回查询对象的集合。Map
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return Map 	 */
	@SuppressWarnings("unchecked")
	public Map findMap(String finalSql,Object[] object);
	/**
	 * 	通过SQL返回查询对象的集合。Map
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user WHERE user_id='01'";
	 * @param Object[] object  new Object[]{""};
	 * @param int[] argTyes    new int[]{Types.VARCHAR}
	 * @author LiRui
	 * @date June 25, 2013
	 * @return Map 
	 */
	@SuppressWarnings("unchecked")
	public Map findMap(String finalSql,Object[] object, int[] argTyes);
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return List<E> 对象数组。
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql);
	/**
	 * 	通过SQL返回查询对象的集合。List<?>
	 * 
	 * @param String型SQL.如：finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date Aug 24, 2012
	 * @return List<E> 对象数组。	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,Object[] object);
	/**
	 *  通过SQL返回查询对象的集合。List<?>
	 *  
	 * @param String型Sql 如:finalSql = "SELECT user_name,user_pwd FROM user";
	 * @param RowMapper rowMapper
	 * @author LiRui
	 * @date June 25, 2013
	 * @return List<E> 对象数组。 
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,RowMapper rowMapper);
	/**
	 *  通过SQL返回查询对象的集合。List<?>
	 *  
	 * @param String型Sql 如:finalSql = "SELECT user_name,user_pwd FROM user_id like ?";
	 * @param Object[] objects 
	 * @param RowMapper rowMapper
	 * @author LiRui
	 * @date June 25, 2013
	 * @return List<E> 对象数组。 
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,Object[] objects,RowMapper rowMapper);
	/**
	 *  通过SQL返回查询对象的集合。List<?>
	 *  
	 * @param String型Sql 如:finalSql = "SELECT user_name,user_pwd FROM user_id like ?";
	 * @param Object[] objects 
	 * @param Class<?> clazz
	 * @author LiRui
	 * @date June 25, 2013
	 * @return List<E> 对象数组。 
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,Object[] objects,Class<?> clazz);
	/**
	 *  通过SQL返回查询对象的集合。List<?>
	 *  
	 * @param String型Sql 如:finalSql = "SELECT user_name,user_pwd FROM user_id like ?";
	 * @param Object[] objects 如： new Object[]{'01'}
	 * @param int[] argTypes   如： new int[]{Types.VARCHAR}
	 * @param Class<?> clazz   如： String.class
	 * @author LiRui
	 * @date June 25, 2013
	 * @return List<E> 对象数组。 
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,Object[] objects,int[] argTypes);
	/**
	 *  通过SQL返回查询对象的集合。List<?>
	 *  
	 * @param String型Sql 如:finalSql = "SELECT user_name,user_pwd FROM user_id like ?";
	  * @param Object[] objects 如： new Object[]{'01'}
	 * @param int[] argTypes   如： new int[]{Types.VARCHAR}
	 * @param Class<?> clazz   如： String.class
	 * @author LiRui
	 * @date June 25, 2013
	 * @return List<E> 对象数组。 
	 */
	@SuppressWarnings("unchecked")
	public List findForList(String finalSql,Object[] objects,int[] argTypes,Class<?> clazz);
	/**
	 * 	通过SQL返回查询对象。	 * 
	 * @param String型SQL.如：finalSql = "SELECT * FROM user WHERE user_id='01'";
	 * @param object型对象.如: USER.class
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return Object对象。	 */
	public Object findForObject(String finalSql, Class<?> clazz);
	/**
	 * 通过SQL返回查询对象。
	 * 
	 * @param String型Sql 如：finalSql = "SELECT user_name FROM user Where" user_id=1;
	 * @param RowMapper rowMapper
	 * @return Object 
	 * @author LiRui
	 * @date June 25,2013 
	 */
	@SuppressWarnings("unchecked")
	public Object findForObject(String finalSql, RowMapper rowMapper); 
	/**
	 * 通过SQL返回查询对象。
	 * 
	 * @param String型Sql 如：finalSql = "SELECT user_name FROM user Where" user_id=?;
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @param RowMapper rowMapper
	 * @return Object 
	 * @author LiRui
	 * @date June 25,2013 
	 */
	@SuppressWarnings("unchecked")
	public Object findForObject(String finalSql, Object[] objects,RowMapper rowMapper);
	/**
	 * 通过SQL返回查询对象。
	 * 
	 * @param String型Sql 如：finalSql = "SELECT user_name FROM user Where" user_id=?;
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @param int[] argTypes
	 * @param Class<?> clazz
	 * @return Object 
	 * @author LiRui
	 * @date June 25,2013 
	 */
	public Object findForObject(String finalSql, Object[] objects,int[] argTypes, Class<?> clazz );
	/**
	 * 通过SQL返回查询对象。
	 * 
	 * @param String型Sql 如：finalSql = "SELECT user_name FROM user Where" user_id=?;
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @param int[] argTypes
	 * @param RowMapper rowMapper
	 * @return Object 
	 * @author LiRui
	 * @date June 25,2013 
	 */
	@SuppressWarnings("unchecked")
	public Object findForObject(String finalSql, Object[] objects,int[] argTypes, RowMapper rowMapper );
	/**
	 * 	通过SQL删除数据信息。
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String delete(String finalSql);
	/**
	 * 	通过SQL删除数据信息。	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '?'";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date June 25, 2013
	 * @return String型logger信息。	 */
	public String delete(String finalSql ,Object[] object);
	/**
	 * 	通过SQL删除数据信息。
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '?'";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @param int[] argsType 如： new int[]{Types.VARCHAR}
	 * @author LiRui
	 * @date June 25, 2013
	 * @return String型logger信息。
	 */
	public String delete(String finalSql, Object[] object ,int[] argsTypes);
	/**
	 * 	通过SQL删除数据信息。
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '01'";
	 * @author LiRui
	 * @date June 25, 2013
	 * @return int
	 */
	public int deleteForInt(String finalSql);
	/**
	 * 	通过SQL删除数据信息。
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = ?";
	 * @param object[]对象数组 如：new Object[] {'01'}
	 * @author LiRui
	 * @date June 25, 2013
	 * @return int
	 */
	public int deleteForInt(String finalSql ,Object[] object);
	/**
	 * 	通过SQL删除数据信息。
	 * 
	 * @param String型SQL.如：finalSql = "DELETE FROM user WHERE user_id = '01'";
	 * @param PreparedStatementSetter preparedStatementSetter
	 * @author LiRui
	 * @date June 25, 2013
	 * @return int
	 */
	public int deleteForInt(String finalSql, PreparedStatementSetter preparedStatementSetter);
	/**
	 *  通过SQL添加数据信息	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES('','','')";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息.
	 */
	public String insert(String finalSql);
	/**
	 *  通过SQL添加数据信息	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES(?,?,?)";
	 * @param object[]对象数组 如：new Object[] {'1','2','3'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。	 */
	public String insert(String finalSql, Object[] object);
	/**
	 *  通过SQL添加数据信息
	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES('','','')";
	 * @author LiRui
	 * @date June 25, 2013
	 * @return int
	 */
	public int insertForInt(String finalSql);
	/**
	 *  通过SQL添加数据信息
	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES(?,?,?)";
	 * @param Object[] object 如：new Object[]{1,2,3}
	 * @author LiRui
	 * @date June 25, 2013
	 * @return int
	 */
	public int insertForInt(String finalSql, Object[] object);
	/**
	 *  通过SQL添加数据信息
	 * 
	 * @param String型SQL.如：finalSql = "INSERT INTO user VALUES(?,?,?)";
	 * @param PreparedStatementSetter preparedStatementSetter
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public int insertForInt(String finalSql,PreparedStatementSetter preparedStatementSetter);
	/**
	 * 通过SQL修改数据信息	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET name='1' WHERE user_id='01'";
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String update(String finalSql);
	/**
	 *  通过SQL修改数据信息	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param object[]对象数组 如：new Object[] {'jack','20','0001'}
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。	 */
	public String update(String finalSql, Object[] object);
	/**
	 *  通过SQL修改数据信息
	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param object[]对象数组 如：new Object[] {'jack','20','0001'}
	 * @param int[] argsTypes 如：new int[]{Types.VARCHAR}
	 * @author LiRui
	 * @date June 25, 2013
	 * @return String型logger信息。
	 */
	public String update(String finalSql, Object[] object ,int[] argsTypes);
	/**
	 *  通过SQL修改数据信息
	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param BatchPreparedStatementSetter batchPreparedStatementSetter
	 * @author LiRui
	 * @date June 25, 2013
	 * @return String型logger信息。
	 */
	public String update(String finalSql ,BatchPreparedStatementSetter batchPreparedStatementSetter);
	/**
	 * 通过SQL修改数据信息	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET name='1' WHERE user_id='01'";
	 * @author LiRui
	 * @date Aug 23, 2012
	 * @return int。	 */
	public int updateForInt(String finalSql);
	/**
	 *  通过SQL修改数据信息	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param object[]对象数组 如：new Object[] {'jack','20','0001'}
	 * @author LiRui
	 * @date Aug 23, 2012
	 * @return int。	 */
	public int updateForInt(String finalSql, Object[] object);
	/**
	 *  通过SQL修改数据信息
	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param PreparedStatementSetter preparedStatementSetter
	 * @author LiRui
	 * @date Aug 23, 2012
	 * @return int。
	 */
	public int updateForInt(String finalSql, PreparedStatementSetter preparedStatementSetter);
	/**
	 *  通过SQL修改数据信息
	 * 
	 * @param String型SQL.如：finalSql = "UPDATE user SET user_name=?,user_age=? WHERE user_id=?";
	 * @param PreparedStatementCreator preparedStatementCreator
	 * @param KeyHolder generatedKeyHolder
	 * @author LiRui
	 * @date Aug 23, 2012
	 * @return int。
	 */
	public int updateForInt(PreparedStatementCreator preparedStatementCreator,KeyHolder generatedKeyHolder);
	/**
	 * 通过SQL返回LONG型数据
	 * 
	 * @param String型SQL 如：finalSql = "SELECT COUNT(*) FROM User";
	 * @return long
	 * @author LiRui
	 * @date June 25,2013
	 * */
	public long findForLong(String finalSql);
	/**
	 * 通过SQL返回LONG型数据
	 * 
	 * @param String型SQL 如：finalSql = "SELECT COUNT(*) FROM User WHERE user_id like ?";
	 * @param Object[] object 如： new Object[] {"%Lee%"}
	 * @return long
	 * @author LiRui
	 * @date June 25,2013
	 * */
	public long findForLong(String finalSql, Object[] object);
	/**
	 * 通过SQL返回LONG型数据
	 * 
	 * @param String型SQL 如：finalSql = "SELECT COUNT(*) FROM User WHERE user_id like ?";
	 * @param Object[] object 如： new Object[] {"%Lee%"}
	 * @param int[] argTypes  如： new int[]{Types.VARCHAR}
	 * @return long
	 * @author LiRui
	 * @date June 25,2013
	 * */
	public long findForLong(String finalSql, Object[] object,int[] argTypes);
	/**
	 * 	通过SQL[] 批量处理数据。	 * 
	 * @param String[]型SQL.如：finalSql.toArray(new String[finalSql.size()])
	 * @author LiRui
	 * @date Jul 12, 2012
	 * @return String型logger信息。
	 */
	public String batch(String[] finalSql);
	/**
	 * 通过SQL[] 批量处理数据。
	 * 
	 * @param String sql
	 * @param BatchPreparedStatementSetter batchPreparedStatementSetter
	 * @return String 
	 * @author LiRui
	 * @date June 25,2013 
	 */
	public String batch(String finalSql,BatchPreparedStatementSetter batchPreparedStatementSetter);
	/**
	 * 通过SQL[] 获取SqlRowSet
	 * 
	 * @param String finalSql
	 * @author LiRui
	 * @return org.springframework.jdbc.support.rowset.SqlRowSet
	 * @date June 25,2013
	 * */
	public SqlRowSet findForRowSet(String finalSql);
	/**
	 * 通过SQL[] 获取SqlRowSet
	 * 
	 * @param String finalSql
	 * @param Object[] object 如：new Object[]{}
	 * @author LiRui
	 * @return org.springframework.jdbc.support.rowset.SqlRowSet
	 * @date June 25,2013
	 * */
	public SqlRowSet findForRowSet(String finalSql ,Object[] object);
	/**
	 * 通过SQL[] 获取SqlRowSet
	 * 
	 * @param String finalSql
	 * @param Object[] object 如：new Object[]{}
	 * @param int[] argTypes  如：new int[]{Types.VARCHAR}
	 * @author LiRui
	 * @return org.springframework.jdbc.support.rowset.SqlRowSet
	 * @date June 25,2013
	 * */
	public SqlRowSet findForRowSet(String finalSql ,Object[] object , int[] argTypes);
}
