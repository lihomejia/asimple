package com.company.gap.manure.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.manure.dao.IManureOutStockDao;
import com.company.gap.manure.model.OutStock;

@Repository
public class ManureOutStockDaoImpl extends BaseDaoImpl<OutStock> implements IManureOutStockDao<OutStock> {
}
