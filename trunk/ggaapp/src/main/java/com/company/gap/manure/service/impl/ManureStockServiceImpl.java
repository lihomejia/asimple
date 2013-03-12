package com.company.gap.manure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.manure.dao.IManureStockDao;
import com.company.gap.manure.entity.ManureStock;
import com.company.gap.manure.service.IManureStockService;


@Service
public class ManureStockServiceImpl implements IManureStockService {

	@Autowired
	private IManureStockDao manureStockDao;
	
	public List<ManureStock> queryList() {
		return manureStockDao.queryList();
	}

}
