package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IGrowResourceDao;
import com.company.gap.grow.model.Resource;

@Repository
public class GrowResourceDaoImpl extends BaseDaoImpl<Resource> implements IGrowResourceDao<Resource> {
}
