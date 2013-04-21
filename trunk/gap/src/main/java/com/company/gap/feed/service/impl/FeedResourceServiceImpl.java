package com.company.gap.feed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.feed.dao.FeedResourceDao;
import com.company.gap.feed.entity.FeedResource;
import com.company.gap.feed.enumeration.FeedResourceEnum;
import com.company.gap.feed.service.FeedResourceService;

@Service
public class FeedResourceServiceImpl implements FeedResourceService {
	@Autowired
	private FeedResourceDao feedResourceDao;
	
	public List<FeedResource> findResourceByType(FeedResourceEnum resource) {
		int type = resource.getNumber();
		return feedResourceDao.selectByType(type);
	}

	public int add(FeedResource resource) {
		return feedResourceDao.insert(resource);
	}

	public FeedResource findById(String rid) {
		return feedResourceDao.selectById(rid);
	}

	public int edit(String rid, String resourceName) {
		return feedResourceDao.update(rid,resourceName);
	}

	public int delete(String rid){
		return feedResourceDao.delete(rid);
	}
}
