package com.company.gap.manure.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.manure.model.OutStock;


/**
 * 
 *
 */
public interface IManureOutStockService extends IBaseService<OutStock> {
	
	int save(OutStock t);
	
	int update(OutStock t);
	
	int deleteById(Integer id);
	
	int nullify(Integer id);
}
