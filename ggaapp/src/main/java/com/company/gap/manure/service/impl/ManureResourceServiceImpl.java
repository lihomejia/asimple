package com.company.gap.manure.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.manure.dao.IManureResourceDao;
import com.company.gap.manure.entity.ManureResource;
import com.company.gap.manure.enumeration.ManureResourceType;
import com.company.gap.manure.service.IManureResourceService;

@Service
public class ManureResourceServiceImpl implements IManureResourceService {

	@Autowired
	private IManureResourceDao resourceDao;
	
	@Override
	public List<ManureResource> queryByType(ManureResourceType resource) {
		return resourceDao.queryByType(resource.getType());
	}
	
	@Override
	public List<ManureResource> queryByType(ManureResourceType resource, ManureResource topResource) {
		List<ManureResource> resources = this.queryByType(resource);
		resources.add(0, topResource);
		return resources;
	}
	
	@Override
	public Map<String, Object> findResourceById(int resourceId) {
		return resourceDao.findResourceById(resourceId);
	}
	
	@Override
	public Map<String, Object> findByTypeAndName(int type, String name) {
		return resourceDao.findByTypeAndName(type, name);
	}

	@Override
	public int saveResource(Map<String, Object> data) {
		if (StringUtils.isEmpty(ObjectUtils.toString(data.get("resource_id")))) {
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
	public Map<Integer, ManureResource> queryResId2Res() {
		Map<Integer, ManureResource> resId2Res = new HashMap<Integer, ManureResource>();
		for (ManureResource resource : resourceDao.queryAll()) {
			resId2Res.put(resource.getResource_id(), resource);
		}
		return resId2Res;
	}

	@Override
	public Map<Integer, String> queryResId2Name() {
		Map<Integer, String> resId2Name = new HashMap<Integer, String>();
		for (ManureResource resource : resourceDao.queryAll()) {
			resId2Name.put(resource.getResource_id(), resource.getResource_name());
		}
		return resId2Name;
	}

	
	
}
