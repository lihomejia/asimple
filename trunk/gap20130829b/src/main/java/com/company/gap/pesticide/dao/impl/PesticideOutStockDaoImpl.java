package com.company.gap.pesticide.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.pesticide.dao.IPesticideOutStockDao;
import com.company.gap.pesticide.model.OutStock;

@Repository
public class PesticideOutStockDaoImpl extends BaseDaoImpl<OutStock> implements IPesticideOutStockDao<OutStock> {
}
