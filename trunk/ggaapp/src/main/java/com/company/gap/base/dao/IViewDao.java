package com.company.gap.base.dao;

import java.util.List;

import com.company.gap.base.util.Dto;

public interface IViewDao {

	List<Dto> queryList(String sql, Object[] pros);
	
	int getCount(String sql, Object[] pros);
}
