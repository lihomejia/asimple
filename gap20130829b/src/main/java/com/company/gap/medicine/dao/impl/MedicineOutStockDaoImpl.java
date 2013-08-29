package com.company.gap.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.medicine.dao.IMedicineOutStockDao;
import com.company.gap.medicine.model.OutStock;

@Repository
public class MedicineOutStockDaoImpl extends BaseDaoImpl<OutStock> implements IMedicineOutStockDao<OutStock> {
}
