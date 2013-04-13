package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IHarvestDao;
import com.company.gap.grow.model.Harvest;

@Repository
public class HarvestDaoImpl extends BaseDaoImpl<Harvest> implements IHarvestDao {
	
	public HarvestDaoImpl() {
		super(Harvest.class);
	}

}
