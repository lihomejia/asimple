package com.company.gap.base.dao;

import java.util.List;
import java.util.Map;

public interface IViewDao {

	List<Map<String, Object>> queryList(String sql, Object[] pros);
	
	int getCount(String sql, Object[] pros);
}
