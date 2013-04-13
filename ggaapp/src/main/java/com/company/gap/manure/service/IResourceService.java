package com.company.gap.manure.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.service.IBaseService;
import com.company.gap.manure.enumeration.ResourceType;
import com.company.gap.manure.model.Resource;

public interface IResourceService extends IBaseService<Resource> {
	
	List<Resource> queryByType(ResourceType type);
	
	List<Resource> queryByType(ResourceType type, boolean containTop);
	
	Resource findByTypeAndName(int type, String name);
	
	Map<Integer, Resource> queryResId2Res();
	
	Map<Integer, String> queryResId2Name();
}
