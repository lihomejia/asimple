package com.company.gap.disinfectant.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.disinfectant.dao.IDisinfectantOutStockDao;
import com.company.gap.disinfectant.model.OutStock;

@Repository
public class DisinfectantOutStockDaoImpl extends BaseDaoImpl<OutStock> implements IDisinfectantOutStockDao<OutStock> {
}
