package com.company.gap.grow.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.grow.model.Harvest;

public interface IGrowHarvestService extends IBaseService<Harvest> {
	public List<Harvest> findByRegisterId(Integer registerId);
}
