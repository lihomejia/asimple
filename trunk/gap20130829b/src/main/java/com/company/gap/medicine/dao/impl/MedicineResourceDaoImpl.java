package com.company.gap.medicine.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.medicine.dao.IMedicineResourceDao;
import com.company.gap.medicine.model.Resource;

@Repository
public class MedicineResourceDaoImpl extends BaseDaoImpl<Resource> implements IMedicineResourceDao<Resource> {
}
