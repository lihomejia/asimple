package com.company.gap.resource.service.impl;

import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.resource.dao.IResourceDao;
import com.company.gap.resource.service.IResourceService;

@Service
public class ResourceServiceImpl implements IResourceService {

	@Autowired
	private IResourceDao resourceDao;
	
	@Override
	public Map<String, Object> findResourceById(int resourceId) {
		return resourceDao.findResourceById(resourceId);
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
}
