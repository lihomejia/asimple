package com.company.gap.resource.dao;

import java.util.Map;

public interface IResourceDao {

	Map<String, Object> findResourceById(int resourceId);

	int insert(Map<String, Object> data);

	int update(Map<String, Object> data);

	int delete(int... resourceIds);
}
