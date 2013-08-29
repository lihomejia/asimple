package com.company.gap.base.util.sql;

public interface PagerAdapter {
	
	
	String toPagerSql(String sql, int start, int count);
}
