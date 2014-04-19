package com.company.gap.feed.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.feed.model.OutStock;


/**
 * 
 *
 */
public interface IFeedOutStockService extends IBaseService<OutStock> {
	
	int save(OutStock t);
	
	int update(OutStock t);
	
	int deleteById(Integer id);
	
	int nullify(Integer id);
}
