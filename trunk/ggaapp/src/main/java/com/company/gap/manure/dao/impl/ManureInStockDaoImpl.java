package com.company.gap.manure.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.manure.dao.IManureInStockDao;
import com.company.gap.manure.model.InStock;

@Repository
public class ManureInStockDaoImpl extends BaseDaoImpl<InStock> implements IManureInStockDao<InStock> {

	public ManureInStockDaoImpl() {
		super(InStock.class);
	}
}
