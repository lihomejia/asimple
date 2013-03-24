package com.company.gap.pesticide.service;

import java.util.List;
import java.util.Map;

import com.company.gap.pesticide.entity.PesticideResource;
import com.company.gap.pesticide.enumeration.PesticideResourceType;

public interface IPesticideResourceService {
	
	List<PesticideResource> queryByType(PesticideResourceType resource);
	
	List<PesticideResource> queryByType(PesticideResourceType resource, PesticideResource topResource);
	
	Map<String, Object> findResourceById(int resourceId);
	
	Map<String, Object> findByTypeAndName(int type, String name);

	int saveResource(Map<String, Object> data);
	
	int delete(int... resourceIds);
	
	Map<Integer, PesticideResource> queryResId2Res();
	
	Map<Integer, String> queryResId2Name();
}
