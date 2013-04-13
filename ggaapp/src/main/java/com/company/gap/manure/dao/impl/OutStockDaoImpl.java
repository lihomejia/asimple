package com.company.gap.manure.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.manure.dao.IOutStockDao;
import com.company.gap.manure.model.OutStock;

@Repository
public class OutStockDaoImpl extends BaseDaoImpl<OutStock> implements IOutStockDao<OutStock> {

	public OutStockDaoImpl() {
		super(OutStock.class);
	}
}
