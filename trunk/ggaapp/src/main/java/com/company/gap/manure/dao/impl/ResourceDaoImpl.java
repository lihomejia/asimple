package com.company.gap.manure.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.manure.dao.IResourceDao;
import com.company.gap.manure.model.Resource;

@Repository
public class ResourceDaoImpl extends BaseDaoImpl<Resource> implements IResourceDao<Resource> {

	public ResourceDaoImpl() {
		super(Resource.class);
	}
}
