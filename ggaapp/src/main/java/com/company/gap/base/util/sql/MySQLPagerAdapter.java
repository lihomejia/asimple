package com.company.gap.base.util.sql;

public class MySQLPagerAdapter implements PagerAdapter {

	private static PagerAdapter pagerAdapter = new MySQLPagerAdapter();

	public static PagerAdapter getInstance() {
		return pagerAdapter;
	}
	
	@Override
	public String toPagerSql(String sql, int start, int count) {
		return sql + " limit " + (start - 1) + "," + count;
	}

}
