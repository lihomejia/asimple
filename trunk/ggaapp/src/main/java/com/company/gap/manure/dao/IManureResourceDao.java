package com.company.gap.manure.dao;

import java.util.List;
import java.util.Map;

import com.company.gap.manure.entity.ManureResource;

public interface IManureResourceDao {
	
	List<ManureResource> queryByType(int resourceType);

	Map<String, Object> findResourceById(int resourceId);
	
	Map<String, Object> findByTypeAndName(int type, String name);
	
	List<ManureResource> queryAll();

	int insert(Map<String, Object> data);

	int update(Map<String, Object> data);

	int delete(int... resourceIds);
}
