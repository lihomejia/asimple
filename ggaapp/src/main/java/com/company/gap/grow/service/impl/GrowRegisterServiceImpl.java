package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.grow.dao.IGrowRegisterDao;
import com.company.gap.grow.entity.GrowRegister;
import com.company.gap.grow.service.IGrowRegisterService;

@Service
public class GrowRegisterServiceImpl implements IGrowRegisterService {

	@Autowired
	private IGrowRegisterDao registerDao;
	
	@Override
	public GrowRegister findGrowRegister(int registerId) {
		return registerDao.findGrowRegister(registerId);
	}

	@Override
	public int save(GrowRegister register) {
		if (register.getRegister_id() == 0) {
			return registerDao.insert(register);
		}
		else {
			return registerDao.update(register);
		}
	}
	
	@Override
	public int auditing(int registerId) {
		return registerDao.auditing(registerId);
	}

	@Override
	public int complete(int registerId) {
		return registerDao.complete(registerId);
	}

	@Override
	public int archive(int registerId) {
		return registerDao.archive(registerId);
	}
	
	@Override
	public int delete(int registerId) {
		return registerDao.delete(registerId);
	}

	

}
