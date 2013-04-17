package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IGrowIrrigateDao;
import com.company.gap.grow.model.Irrigate;

@Repository
public class GrowIrrigateDaoImpl extends BaseDaoImpl<Irrigate> implements IGrowIrrigateDao {

	public GrowIrrigateDaoImpl() {
		super(Irrigate.class);
	}
}
