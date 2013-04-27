package com.company.gap.medicine.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.service.IBaseService;
import com.company.gap.medicine.enumeration.ResourceType;
import com.company.gap.medicine.model.Resource;

public interface IMedicineResourceService extends IBaseService<Resource> {
	
	List<Resource> queryByType(ResourceType type);
	
	List<Resource> queryByType(ResourceType type, boolean containTop);
	
	Map<Integer, Resource> queryResId2Res();
	
	Map<Integer, String> queryResId2Name();
}
