package com.company.gap.grow.service;

import com.company.gap.base.util.Dto;

public interface IGrowIrrigateService {
	Dto findIrrigateById(int irrigate_id);
	
	int save(Dto data);
	
	int delete(int irrigate_id);
}
