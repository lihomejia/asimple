package com.company.gap.manure.dao;

import java.util.List;

import com.company.gap.base.util.Dto;

public interface IManureResourceDao {
	
	List<Dto> queryByType(int resourceType);

	Dto findResourceById(int resourceId);
	
	Dto findByTypeAndName(int type, String name);
	
	List<Dto> queryAll();

	int insert(Dto data);

	int update(Dto data);

	int delete(int... resourceIds);
}
