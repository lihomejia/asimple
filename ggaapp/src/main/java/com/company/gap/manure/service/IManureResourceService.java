package com.company.gap.manure.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.util.Dto;
import com.company.gap.manure.enumeration.ManureResourceType;

public interface IManureResourceService {
	
	List<Dto> queryByType(ManureResourceType resource);
	
	List<Dto> queryByType(ManureResourceType resource, boolean containTop);
	
	Dto findResourceById(int resourceId);
	
	Dto findByTypeAndName(int type, String name);

	int saveResource(Dto data);
	
	int delete(int... resourceIds);
	
	Map<Integer, Dto> queryResId2Res();
	
	Map<Integer, String> queryResId2Name();
}
