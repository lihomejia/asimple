package com.company.gap.base.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.gap.base.dao.search.Searcher;
import com.company.gap.base.service.IViewService;
import com.company.gap.manure.entity.ManureStock;


@Service
public class ViewServiceImpl implements IViewService {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryList(Searcher searcher) {
		
		List<ManureStock> datas = new ArrayList<ManureStock>();
		for (int i = 0; i < 15; i++) {
			ManureStock manureStock = new ManureStock();
			manureStock.setMastockId(i+1);
			manureStock.setMastockTotqty(new BigDecimal(i + 100));
			datas.add(manureStock);
		}
		
		return (List<T>) datas;
	}

}