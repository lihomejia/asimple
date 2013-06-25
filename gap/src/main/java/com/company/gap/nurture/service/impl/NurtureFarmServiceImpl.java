package com.company.gap.nurture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.nurture.dao.INurtureFarmDao;
import com.company.gap.nurture.model.Farm;
import com.company.gap.nurture.service.INurtureFarmService;

@Service
public class NurtureFarmServiceImpl extends BaseServiceImpl<Farm> implements INurtureFarmService {

	@Autowired
	private INurtureFarmDao dao;

	@Override
	protected IBaseDao<Farm> get() {
		return this.dao;
	}

	@Override
	public List<Farm> findByRegisterId(Integer registerId) {
		Farm t = new Farm();
		t.setRegisterId(registerId);
		return this.findList(t);
	}
	
	
}