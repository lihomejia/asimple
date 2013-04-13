package com.company.gap.manure.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.manure.dao.IInStockDao;
import com.company.gap.manure.model.InStock;

@Repository
public class InStockDaoImpl extends BaseDaoImpl<InStock> implements IInStockDao<InStock> {

	public InStockDaoImpl() {
		super(InStock.class);
	}
}
