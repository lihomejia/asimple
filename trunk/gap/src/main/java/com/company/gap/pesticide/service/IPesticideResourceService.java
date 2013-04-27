package com.company.gap.pesticide.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.service.IBaseService;
import com.company.gap.pesticide.enumeration.ResourceType;
import com.company.gap.pesticide.model.Resource;

public interface IPesticideResourceService extends IBaseService<Resource> {
	
	List<Resource> queryByType(ResourceType type);
	
	List<Resource> queryByType(ResourceType type, boolean containTop);
	
	Map<Integer, Resource> queryResId2Res();
	
	Map<Integer, String> queryResId2Name();
}
