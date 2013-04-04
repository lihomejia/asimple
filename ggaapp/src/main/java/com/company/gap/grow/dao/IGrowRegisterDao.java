package com.company.gap.grow.dao;

import java.util.List;
import java.util.Map;

import com.company.gap.grow.entity.GrowRegister;

public interface IGrowRegisterDao {
	GrowRegister findGrowRegister(int registerId);
	
	int insert(GrowRegister register);
	
	int update(GrowRegister register);
	
	int auditing(int registerId);
	
	int complete(int registerId);
	
	int archive(int registerId);
	
	int delete(int registerId);
	
	List<Map<String, Object>> findGrowingInfos();
	
}
