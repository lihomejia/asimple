package com.company.gap.grow.dao;

import com.company.gap.base.util.Dto;

public interface IGrowFarmDao {
	Dto findFarmById(int farm_id);
	
	int insert(Dto data);
	
	int update(Dto data);
	
	int delete(int farm_id);
}
