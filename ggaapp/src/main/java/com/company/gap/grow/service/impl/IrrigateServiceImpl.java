package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.dao.IIrrigateDao;
import com.company.gap.grow.model.Irrigate;
import com.company.gap.grow.service.IIrrigateService;

@Service
public class IrrigateServiceImpl extends BaseServiceImpl<Irrigate> implements IIrrigateService {

	@Autowired
	private IIrrigateDao dao;

	@Override
	protected IBaseDao<Irrigate> get() {
		return this.dao;
	}
}