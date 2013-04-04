package com.company.gap.grow.service;

import java.util.List;
import java.util.Map;

import com.company.gap.grow.entity.GrowRegister;

public interface IGrowRegisterService {
	GrowRegister findGrowRegister(int registerId);
	
	int save(GrowRegister register);
	
	int auditing(int registerId);
	
	int complete(int registerId);
	
	int archive(int registerId);

	int delete(int registerId);
	
	List<Map<String, Object>> findGrowingInfos();
}
