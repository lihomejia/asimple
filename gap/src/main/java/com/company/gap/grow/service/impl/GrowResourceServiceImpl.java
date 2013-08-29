package com.company.gap.grow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.controller.BaseController;
import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.grow.dao.IGrowResourceDao;
import com.company.gap.grow.enumeration.ResourceType;
import com.company.gap.grow.model.Resource;
import com.company.gap.grow.service.IGrowResourceService;

@Service
public class GrowResourceServiceImpl extends BaseServiceImpl<Resource> implements IGrowResourceService {

	@Autowired
	private IGrowResourceDao<Resource> dao;
	
	protected IBaseDao<Resource> get() {
		return this.dao;
	}


	@Override
	public List<Resource> queryByType(ResourceType type) {
		Resource resource = new Resource();
		resource.setType(type.getType());
		return dao.findList(resource);
	}
	
	@Override
	public List<Resource> queryByType(ResourceType type, boolean containTop) {
		List<Resource> resources = this.queryByType(type);
		if (containTop) {
			Resource all = new Resource();
			all.setName(BaseController.__ALL);
			resources.add(0, all);
		}
		return resources;
	}

	@Override
	public Map<Integer, Resource> queryResId2Res() {
		Map<Integer, Resource> resId2Res = new HashMap<Integer, Resource>();
		for (Resource resource : this.findList()) {
			resId2Res.put(resource.getId(), resource);
		}
		return resId2Res;
	}

	@Override
	public Map<Integer, String> queryResId2Name() {
		Map<Integer, String> resId2Name = new HashMap<Integer, String>();
		for (Resource resource : this.findList()) {
			resId2Name.put(resource.getId(), resource.getName());
		}
		return resId2Name;
	}
}