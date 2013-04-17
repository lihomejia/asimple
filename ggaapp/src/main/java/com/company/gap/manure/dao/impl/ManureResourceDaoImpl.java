package com.company.gap.manure.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.manure.dao.IManureResourceDao;
import com.company.gap.manure.model.Resource;

@Repository
public class ManureResourceDaoImpl extends BaseDaoImpl<Resource> implements IManureResourceDao<Resource> {
}
