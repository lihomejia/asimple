package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IGrowHarvestDao;
import com.company.gap.grow.model.Harvest;

@Repository
public class GrowHarvestDaoImpl extends BaseDaoImpl<Harvest> implements IGrowHarvestDao {
	
	public GrowHarvestDaoImpl() {
		super(Harvest.class);
	}

}
