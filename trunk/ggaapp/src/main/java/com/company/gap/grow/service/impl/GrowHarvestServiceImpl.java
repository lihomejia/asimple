package com.company.gap.grow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.Dto;
import com.company.gap.grow.dao.IGrowHarvestDao;
import com.company.gap.grow.service.IGrowHarvestService;
import com.company.gap.grow.tab.THarvest;

@Service
public class GrowHarvestServiceImpl implements IGrowHarvestService {

	@Autowired
	private IGrowHarvestDao harvestDao;
	
	@Override
	public int delete(int farm_id) {
		return harvestDao.delete(farm_id);
	}

	@Override
	public Dto findHarvestById(int farm_id) {
		return harvestDao.findHarvestById(farm_id);
	}

	@Override
	public int save(Dto data) {
		int ret = 0;
		if (data.getInt(THarvest.ID) == 0) {
			harvestDao.insert(data);
		}
		else {
			harvestDao.update(data);
		}
		return ret;
	}
}