package com.company.gap.grow.dao;

import com.company.gap.base.util.Dto;

public interface IGrowHarvestDao {
	Dto findHarvestById(int harvest_id);
	
	int insert(Dto data);
	
	int update(Dto data);
	
	int delete(int harvest_id);
}
