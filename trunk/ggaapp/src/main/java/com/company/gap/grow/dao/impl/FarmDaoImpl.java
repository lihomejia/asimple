package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IFarmDao;
import com.company.gap.grow.model.Farm;

@Repository
public class FarmDaoImpl extends BaseDaoImpl<Farm> implements IFarmDao {
	
	public FarmDaoImpl() {
		super(Farm.class);
	}

}
