package com.company.gap.pesticide.dao;

import java.util.List;
import java.util.Map;

import com.company.gap.pesticide.entity.PesticideResource;

public interface IPesticideResourceDao {
	
	List<PesticideResource> queryByType(int resourceType);

	Map<String, Object> findResourceById(int resourceId);
	
	Map<String, Object> findByTypeAndName(int type, String name);
	
	List<PesticideResource> queryAll();

	int insert(Map<String, Object> data);

	int update(Map<String, Object> data);

	int delete(int... resourceIds);
}
