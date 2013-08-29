package com.company.gap.medicine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.medicine.dao.IMedicineResourceDao;
import com.company.gap.medicine.model.Resource;
import com.company.gap.medicine.service.IMedicineResourceService;

@Service
public class MedicineResourceServiceImpl extends BaseServiceImpl<Resource> implements IMedicineResourceService {

	@Autowired
	private IMedicineResourceDao<Resource> dao;
	
	protected IBaseDao<Resource> get() {
		return this.dao;
	}
}