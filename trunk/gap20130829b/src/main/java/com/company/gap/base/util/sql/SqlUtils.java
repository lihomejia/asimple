package com.company.gap.base.util.sql;

public class SqlUtils {
	
	public static String toPagerSql(String sql, int start, int count) {
		return MySQLPagerAdapter.getInstance().toPagerSql(sql, start, count);
	}
}
