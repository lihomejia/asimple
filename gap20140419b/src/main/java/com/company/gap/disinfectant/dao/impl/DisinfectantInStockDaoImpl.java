package com.company.gap.disinfectant.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.disinfectant.dao.IDisinfectantInStockDao;
import com.company.gap.disinfectant.model.InStock;

@Repository
public class DisinfectantInStockDaoImpl extends BaseDaoImpl<InStock> implements IDisinfectantInStockDao<InStock> {
}
