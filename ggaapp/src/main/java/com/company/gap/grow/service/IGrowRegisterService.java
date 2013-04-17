package com.company.gap.grow.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.grow.model.Register;

public interface IGrowRegisterService extends IBaseService<Register> {
	
	List<Register> findListByGrowStatus(Integer growstatus);
	
	int complete(Integer id);
	
	int archive(Integer id);
}

