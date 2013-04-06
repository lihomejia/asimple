package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.Dto;
import com.company.gap.grow.dao.IGrowFarmDao;
import com.company.gap.grow.service.IGrowFarmService;
import com.company.gap.grow.tab.TFarm;

@Service
public class GrowFarmServiceImpl implements IGrowFarmService {

	@Autowired
	private IGrowFarmDao farmDao;
	
	@Override
	public int delete(int harvest_id) {
		return farmDao.delete(harvest_id);
	}

	@Override
	public Dto findFarmById(int harvest_id) {
		return farmDao.findFarmById(harvest_id);
	}

	@Override
	public int save(Dto data) {
		int ret = 0;
		if (data.getInt(TFarm.ID) == 0) {
			farmDao.insert(data);
		}
		else {
			farmDao.update(data);
		}
		return ret;
	}
}