package com.company.gap.medicine.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.medicine.model.OutStock;


/**
 * 
 *
 */
public interface IMedicineOutStockService extends IBaseService<OutStock> {
	
	int save(OutStock t);
	
	int update(OutStock t);
	
	int deleteById(Integer id);
	
	int nullify(Integer id);
}
