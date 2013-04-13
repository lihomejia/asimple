package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IIrrigateDao;
import com.company.gap.grow.model.Irrigate;

@Repository
public class IrrigateDaoImpl extends BaseDaoImpl<Irrigate> implements IIrrigateDao {

	public IrrigateDaoImpl() {
		super(Irrigate.class);
	}
}
