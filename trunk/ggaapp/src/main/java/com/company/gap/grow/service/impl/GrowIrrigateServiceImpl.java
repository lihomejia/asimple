package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.Dto;
import com.company.gap.grow.dao.IGrowIrrigateDao;
import com.company.gap.grow.service.IGrowIrrigateService;
import com.company.gap.grow.tab.TIrrigate;

@Service
public class GrowIrrigateServiceImpl implements IGrowIrrigateService {

	@Autowired
	private IGrowIrrigateDao irrigateDao;
	
	@Override
	public int delete(int irrigate_id) {
		return irrigateDao.delete(irrigate_id);
	}

	@Override
	public Dto findIrrigateById(int irrigate_id) {
		return irrigateDao.findIrrigateById(irrigate_id);
	}

	@Override
	public int save(Dto data) {
		int ret = 0;
		if (data.getInt(TIrrigate.ID) == 0) {
			irrigateDao.insert(data);
		}
		else {
			irrigateDao.update(data);
		}
		return ret;
	}
}