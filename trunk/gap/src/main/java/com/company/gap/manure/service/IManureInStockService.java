package com.company.gap.manure.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.manure.model.InStock;

/**
 * 入库的 审批/作废 需要更新库存状态.
 *
 */
public interface IManureInStockService extends IBaseService<InStock> {
	
	
	int approve(Integer id);
	
	int nullify(Integer id);
	
	
}
