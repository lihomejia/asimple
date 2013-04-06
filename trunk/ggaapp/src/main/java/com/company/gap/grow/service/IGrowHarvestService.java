package com.company.gap.grow.service;

import com.company.gap.base.util.Dto;

public interface IGrowHarvestService {
	Dto findHarvestById(int harvest_id);
	
	int save(Dto data);
	
	int delete(int harvest_id);
}
