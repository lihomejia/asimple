package com.company.gap.grow.service;

import com.company.gap.base.util.Dto;

public interface IGrowFarmService {
	Dto findFarmById(int farm_id);
	
	int save(Dto data);
	
	int delete(int farm_id);
}
