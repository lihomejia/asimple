package com.company.gap.pesticide.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.pesticide.dao.IPesticideResourceDao;
import com.company.gap.pesticide.entity.PesticideResource;
import com.company.gap.pesticide.enumeration.PesticideResourceType;
import com.company.gap.pesticide.service.IPesticideResourceService;

@Service
public class PesticideResourceServiceImpl implements IPesticideResourceService {

	@Autowired
	private IPesticideResourceDao resourceDao;
	
	@Override
	public List<PesticideResource> queryByType(PesticideResourceType resource) {
		return resourceDao.queryByType(resource.getType());
	}
	
	@Override
	public List<PesticideResource> queryByType(PesticideResourceType resource, PesticideResource topResource) {
		List<PesticideResource> resources = this.queryByType(resource);
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
	public Map<Integer, PesticideResource> queryResId2Res() {
		Map<Integer, PesticideResource> resId2Res = new HashMap<Integer, PesticideResource>();
		for (PesticideResource resource : resourceDao.queryAll()) {
			resId2Res.put(resource.getResource_id(), resource);
		}
		return resId2Res;
	}

	@Override
	public Map<Integer, String> queryResId2Name() {
		Map<Integer, String> resId2Name = new HashMap<Integer, String>();
		for (PesticideResource resource : resourceDao.queryAll()) {
			resId2Name.put(resource.getResource_id(), resource.getResource_name());
		}
		return resId2Name;
	}

	
	
}
