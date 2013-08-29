package com.company.gap.nurture.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.nurture.model.Register;

public interface INurtureRegisterService extends IBaseService<Register> {
	
	List<Register> findListByNurtureStatus(Integer nurturestatus);
	
	int complete(Integer id);
	
	int archive(Integer id);
}

