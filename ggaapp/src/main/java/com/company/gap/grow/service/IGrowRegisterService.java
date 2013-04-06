package com.company.gap.grow.service;

import java.util.List;

import com.company.gap.base.util.Dto;

public interface IGrowRegisterService {
	Dto findGrowRegister(int registerId);
	
	int save(Dto register);
	
	int auditing(int registerId);
	
	int complete(int registerId);
	
	int archive(int registerId);

	int delete(int registerId);
	
	List<Dto> findGrowingInfos();
}
