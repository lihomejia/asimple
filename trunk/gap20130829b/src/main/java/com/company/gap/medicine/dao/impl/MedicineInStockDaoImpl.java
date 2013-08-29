package com.company.gap.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.medicine.dao.IMedicineInStockDao;
import com.company.gap.medicine.model.InStock;

@Repository
public class MedicineInStockDaoImpl extends BaseDaoImpl<InStock> implements IMedicineInStockDao<InStock> {
}
