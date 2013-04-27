package com.company.gap.nurture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.nurture.dao.INurturePesticideDao;
import com.company.gap.nurture.model.Pesticide;
import com.company.gap.nurture.service.INurturePesticideService;

@Service
public class NurturePesticideServiceImpl extends BaseServiceImpl<Pesticide> implements INurturePesticideService {

	@Autowired
	private INurturePesticideDao dao;
	
	@Override
	protected IBaseDao<Pesticide> get() {
		return this.dao;
	}

}
