package com.company.gap.disinfectant.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.disinfectant.model.OutStock;


/**
 * 
 *
 */
public interface IDisinfectantOutStockService extends IBaseService<OutStock> {
	
	int save(OutStock t);
	
	int update(OutStock t);
	
	int deleteById(Integer id);
	
	int nullify(Integer id);
}
