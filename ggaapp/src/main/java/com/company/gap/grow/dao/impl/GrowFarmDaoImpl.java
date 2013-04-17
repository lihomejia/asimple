package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IGrowFarmDao;
import com.company.gap.grow.model.Farm;

@Repository
public class GrowFarmDaoImpl extends BaseDaoImpl<Farm> implements IGrowFarmDao {
	
	public GrowFarmDaoImpl() {
		super(Farm.class);
	}

}
