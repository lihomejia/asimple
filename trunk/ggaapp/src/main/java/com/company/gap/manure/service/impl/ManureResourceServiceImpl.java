package com.company.gap.manure.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.controller.BaseController;
import com.company.gap.base.util.BaseDto;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.dao.IManureResourceDao;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureResourceService;
import com.company.gap.manure.tab.TResource;

@Service
public class ManureResourceServiceImpl implements IManureResourceService {

	@Autowired
	private IManureResourceDao resourceDao;
	
	@Override
	public List<Dto> queryByType(ManureResourceType resource) {
		return resourceDao.queryByType(resource.getType());
	}
	
	@Override
	public List<Dto> queryByType(ManureResourceType resource, boolean containTop) {
		List<Dto> resources = this.queryByType(resource);
		if (containTop) {
			Dto all = new BaseDto();
			all.put(TResource.NAME, BaseController.__ALL);
			resources.add(0, all);
		}
		return resources;
	}
	
	@Override
	public Dto findResourceById(int resourceId) {
		return resourceDao.findResourceById(resourceId);
	}
	
	@Override
	public Dto findByTypeAndName(int type, String name) {
		return resourceDao.findByTypeAndName(type, name);
	}

	@Override
	public int saveResource(Dto data) {
		if (data.getInt(TResource.ID) == 0) {
			return resourceDao.insert(data);
		} 
		else {
			return resourceDao.update(data);
		}
	}

	@Override
	public int delete(int... resourceIds) {
		return resourceDao.delete(resourceIds);
	}
	
	@Override
	public Map<Integer, Dto> queryResId2Res() {
		Map<Integer, Dto> resId2Res = new HashMap<Integer, Dto>();
		for (Dto resource : resourceDao.queryAll()) {
			resId2Res.put(resource.getInt(TResource.ID), resource);
		}
		return resId2Res;
	}

	@Override
	public Map<Integer, String> queryResId2Name() {
		Map<Integer, String> resId2Name = new HashMap<Integer, String>();
		for (Dto resource : resourceDao.queryAll()) {
			resId2Name.put(resource.getInt(TResource.ID), resource.getString(TResource.NAME));
		}
		return resId2Name;
	}

	
	
}
