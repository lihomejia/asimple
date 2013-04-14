package com.company.gap.feed.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.feed.dao.StockDao;
import com.company.gap.feed.entity.Stock;
import com.company.gap.feed.service.StockService;

@Service
public class FeedStockServiceImpl implements StockService {
	
	@Autowired
	private StockDao stockDao;
	
	public Stock findById(String id) {
		return stockDao.selectById(id);
	}

	public int insert(Stock order) {
		return stockDao.insert(order);
	}

	public List<Map<String,Object>> findAll() {
		return stockDao.selecAll();
	}
}
