package com.company.gap.grow.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.grow.model.Farm;

public interface IGrowFarmService extends IBaseService<Farm> {
	
	public List<Farm> findByRegisterId(Integer registerId);
}
