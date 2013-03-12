package com.company.gap.feed.service;

import java.util.List;

import com.company.gap.feed.entity.FeedResource;
import com.company.gap.feed.enumeration.FeedResourceEnum;

public interface FeedResourceService {
	
	/**
	 * 根据饲料资源类别，获得该类别下的所有资源集合。
	 * @param resource
	 */
	List<FeedResource> findResourceByType(FeedResourceEnum resource);

	/**
	 * 添加资源
	 * @param resource
	 */
	int add(FeedResource resource);

	
	FeedResource findById(String rid);

	int edit(String rid, String resourceName);
	
	int delete(String rid);
}
