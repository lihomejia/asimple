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

package com.norming.ess.common.jdbc;

import org.springframework.util.StringUtils;

public class SqlBuilder {
	private static final String PAGING_STATEMENT_PATTERN = "SELECT * FROM ( SELECT AA.* ,ROWNUM RN FROM ( {sql} ) AA WHERE ROWNUM <= {rowNum} )BB WHERE RN > {rn}";
	private static final String TOP_STATEMENT_PATTERN = "SELECT * FROM ( {sql} ) WHERE ROWNUM <= {size}";

	private static final String COUNT_SQL = "SELECT COUNT(#{countField}) FROM (#{sql})";

	/**
	 * 用于使一条select语句变成可以支持分页的SQL语句。
	 * 
	 * @param sql
	 *            需要被包装的SQL语句，包含了各种具体的业务逻辑。
	 * @param rowNum
	 *            结尾行的索引值
	 * @param rn
	 *            开始行的索引值减去1
	 * @return 包装后具有分页功能的SQL字符串
	 */
	public static String wrapPagingStatement(String sql, int rowNum, int rn) {
		return PAGING_STATEMENT_PATTERN.replace("{sql}", sql).replace(
				"{rowNum}", String.valueOf(rowNum)).replace("{rn}",
				String.valueOf(rn));
	}

	/**
	 * 用于使一条select语句变成可以支持分页的SQL语句。
	 * 
	 * @param sql
	 *            需要被包装的SQL语句，包含了各种具体的业务逻辑。
	 * @param startIndex
	 *            起始记录
	 * @param pageSize
	 *            每页显示多少页
	 * @return 包装后具有分页功能的SQL字符串
	 */
	public static String wrapPagingStatement(StringBuilder sql, int startIndex,
			int pageSize) {
		return wrapPagingStatement(sql.toString(), startIndex + pageSize,
				startIndex);
	}

	/**
	 * 用于使一条select语句变成具有限制条数的功能。
	 * 
	 * @param sql
	 *            需要被包装的SQL语句，包含了各种具体的业务逻辑。
	 * @param size
	 *            行数限制
	 * @return 包装后具有行数限制功能的SQL字符串
	 */
	public static String wrapTopStatement(String sql, int size) {
		return TOP_STATEMENT_PATTERN.replace("{sql}", sql).replace("{size}",
				String.valueOf(size));
	}

	/**
	 * 用于使一条select语句具有排序和分页的SQL
	 * 
	 * @param sql
	 *            需要被包装的SQL语句，包含了各种具体的业务逻辑。
	 * @param orderName
	 *            排序名称
	 * @param orderModel
	 *            排序方式
	 * @param startIndex
	 *            开始行的索引值
	 * @param pageSize
	 *            每页显示多少条记录
	 * @return 包装后具有排序和分页功能的SQL字符串
	 */
	public static String wrapOrderPagingStatement(StringBuilder sql,
			String orderName, String orderModel, int startIndex, int pageSize) {
		if (orderName != null && !"".equals(orderName)) {
			String sortType = "DESC";
			if (orderModel != null && !"".equals(orderModel)) {
				sortType = orderModel;
			}
			sql.append(" ORDER BY ").append(orderName).append(" ").append(
					sortType).append(" NULLS LAST ");
		}
		return wrapPagingStatement(sql.toString(), startIndex + pageSize,
				startIndex);
	}

	/**
	 * 用于使一条select语句具有排序的SQL
	 * 
	 * @param sql
	 *            需要被包装的SQL语句，包含了各种具体的业务逻辑。
	 * @param orderName
	 *            排序名称
	 * @param orderModel
	 *            排序方式
	 * @return 包装后具有排序功能的SQL字符串
	 */
	public static String wrapOrderStatement(StringBuilder sql,
			String orderName, String orderModel) {
		if (orderName != null && !"".equals(orderName)) {
			String sortType = "DESC";
			if (orderModel != null && !"".equals(orderModel)) {
				sortType = orderModel;
			}
			sql.append(" ORDER BY ").append(orderName).append(" ").append(
					sortType).append(" NULLS LAST ");
		}
		return sql.toString();
	}

	/**
	 * 用于使一条select语句具有排序(无NULLS LAST语句)和分页的SQL
	 * 
	 * @param 
	 *            需要被包装的SQL语句，包含了各种具体的业务逻辑。
	 * @param orderName
	 *            排序名称
	 * @param orderModel
	 *            排序方式
	 * @param startIndex
	 *            开始行的索引值
	 * @param pageSize
	 *            每页显示多少条记录
	 * @return 包装后具有排序和分页功能的SQL字符串
	 */
	public static String wrapOrderIndexPagingStatement(StringBuilder sql,
			String orderName, String orderModel, int startIndex, int pageSize) {
		if (orderName != null && !"".equals(orderName)) {
			String sortType = "DESC";
			if (orderModel != null && !"".equals(orderModel)) {
				sortType = orderModel;
			}
			sql.append(" ORDER BY ").append(orderName).append(" ").append(
					sortType);
		}
		return wrapPagingStatement(sql.toString(), startIndex + pageSize,
				startIndex);
	}


	/**
	 * 获取查询数量的 SQL
	 * 
	 * @author  2009-11-27
	 * @param sql
	 * @param countField
	 * @return
	 */
	public static String getCountSql(String sql, String countField) {
		String countSql = COUNT_SQL.replace("#{sql}", sql);
		if (StringUtils.hasText(countField)) {
			countSql = countSql.replace("#{countField}", countField);
		} else {
			countSql = countSql.replace("#{countField}", "*");
		}
		return countSql;
	}
	public static void main(String[] args){
		StringBuilder sql = new StringBuilder("SELECT test_id,test_name FROM test_table");
		String orderName = "test_id";
		String orderModel = "desc";
		int startIndex = 0;
		int pageSize = 20;
		String out = SqlBuilder.wrapOrderIndexPagingStatement(sql, orderName, orderModel, startIndex, pageSize);
		System.out.println(out);	
		
	}
}
