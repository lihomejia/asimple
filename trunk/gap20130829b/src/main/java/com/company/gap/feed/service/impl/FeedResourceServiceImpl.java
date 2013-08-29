package com.company.gap.feed.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.feed.dao.IFeedResourceDao;
import com.company.gap.feed.model.Resource;
import com.company.gap.feed.service.IFeedResourceService;

@Service
public class FeedResourceServiceImpl extends BaseServiceImpl<Resource> implements IFeedResourceService {

	@Autowired
	private IFeedResourceDao<Resource> dao;
	
	protected IBaseDao<Resource> get() {
		return this.dao;
	}
}