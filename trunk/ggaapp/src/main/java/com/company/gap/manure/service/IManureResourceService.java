package com.company.gap.manure.service;

import java.util.List;
import java.util.Map;

import com.company.gap.manure.entity.ManureResource;
import com.company.gap.manure.enumeration.ManureResourceType;

public interface IManureResourceService {
	
	List<ManureResource> queryByType(ManureResourceType resource);
	
	List<ManureResource> queryByType(ManureResourceType resource, ManureResource topResource);
	
	Map<String, Object> findResourceById(int resourceId);

	int saveResource(Map<String, Object> data);
	
	int delete(int... resourceIds);
	
	Map<Integer, ManureResource> queryResId2Res();
	
	Map<Integer, String> queryResId2Name();
}
