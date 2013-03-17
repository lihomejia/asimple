package com.company.gap.resource.service;

import java.util.Map;

public interface IResourceService {
	
	Map<String, Object> findResourceById(int resourceId);

	int saveResource(Map<String, Object> data);
	
	int delete(int... resourceIds);
}
