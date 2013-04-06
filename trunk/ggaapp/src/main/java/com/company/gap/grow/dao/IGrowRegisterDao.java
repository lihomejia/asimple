package com.company.gap.grow.dao;

import java.util.List;

import com.company.gap.base.util.Dto;

public interface IGrowRegisterDao {
	Dto findGrowRegister(int registerId);
	
	int insert(Dto register);
	
	int update(Dto register);
	
	int auditing(int registerId);
	
	int complete(int registerId);
	
	int archive(int registerId);
	
	int delete(int registerId);
	
	List<Dto> findGrowingInfos();
	
}
