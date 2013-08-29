package com.company.gap.pesticide.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.pesticide.dao.IPesticideInStockDao;
import com.company.gap.pesticide.model.InStock;

@Repository
public class PesticideInStockDaoImpl extends BaseDaoImpl<InStock> implements IPesticideInStockDao<InStock> {
}
