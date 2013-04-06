package com.company.gap.grow.dao;

import com.company.gap.base.util.Dto;

public interface IGrowIrrigateDao {
	Dto findIrrigateById(int irrigate_id);
	
	int insert(Dto data);
	
	int update(Dto data);
	
	int delete(int irrigate_id);
}
