package com.company.gap.nurture.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.nurture.model.Harvest;

public interface INurtureHarvestService extends IBaseService<Harvest> {
	public List<Harvest> findByRegisterId(Integer registerId);
}
