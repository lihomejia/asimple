package com.company.gap.feed.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.feed.dao.IFeedResourceDao;
import com.company.gap.feed.model.Resource;

@Repository
public class FeedResourceDaoImpl extends BaseDaoImpl<Resource> implements IFeedResourceDao<Resource> {
}
