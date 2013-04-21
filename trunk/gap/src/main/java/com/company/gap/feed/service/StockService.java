package com.company.gap.feed.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.company.gap.feed.entity.Stock;

@Service
public interface StockService {
	
	Stock findById(String id);

	int insert(Stock order);

	List<Map<String,Object>> findAll();
	
}
