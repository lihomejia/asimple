package com.company.gap.pesticide.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.pesticide.model.OutStock;


/**
 * 
 *
 */
public interface IPesticideOutStockService extends IBaseService<OutStock> {
	
	int save(OutStock t);
	
	int update(OutStock t);
	
	int deleteById(Integer id);
	
	int nullify(Integer id);
}
