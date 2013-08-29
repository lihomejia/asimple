package com.company.gap.nurture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.nurture.dao.INurtureManureDao;
import com.company.gap.nurture.model.Manure;
import com.company.gap.nurture.service.INurtureManureService;

@Service
public class NurtureManureServiceImpl extends BaseServiceImpl<Manure> implements INurtureManureService {

	@Autowired
	private INurtureManureDao dao;
	
	@Override
	protected IBaseDao<Manure> get() {
		return this.dao;
	}
	
	@Override
	public List<Manure> findByRegisterId(Integer registerId) {
		Manure t = new Manure();
		t.setRegisterId(registerId);
		return this.findList(t);
	}

}
