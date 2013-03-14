package com.company.gap.feed.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.feed.dao.FeedDao;
import com.company.gap.feed.dao.StockDao;
import com.company.gap.feed.entity.GodownEntry;
import com.company.gap.feed.entity.Stock;
import com.company.gap.feed.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	private FeedDao feedDao;
	@Autowired
	private StockDao stockDao;
	
	@Override
	public boolean storage(GodownEntry godownEntry) {
		int z = 0;
		int r = feedDao.insert(godownEntry);
		Stock stock = stockDao.findByFid(godownEntry.getId());
		if (stock == null) {
			stock = new Stock();
			stock.setId(UUID.randomUUID().toString());
			stock.setFeedid(godownEntry.getRsid());
			stock.setTotalQuantity(godownEntry.getQuantity());
			stock.setStatus(1);
			z = stockDao.insert(stock);
		} else {
			z = stockDao.addQuantity(godownEntry.getQuantity(), stock.getId());
		}
		return (r == 1) && (z == 1);
	}

}
