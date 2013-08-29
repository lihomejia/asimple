package com.company.gap.feed.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.feed.dao.IFeedInStockDao;
import com.company.gap.feed.model.InStock;

@Repository
public class FeedInStockDaoImpl extends BaseDaoImpl<InStock> implements IFeedInStockDao<InStock> {
}
