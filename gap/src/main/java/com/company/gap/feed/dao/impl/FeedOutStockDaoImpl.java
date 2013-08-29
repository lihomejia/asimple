package com.company.gap.feed.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.feed.dao.IFeedOutStockDao;
import com.company.gap.feed.model.OutStock;

@Repository
public class FeedOutStockDaoImpl extends BaseDaoImpl<OutStock> implements IFeedOutStockDao<OutStock> {
}
