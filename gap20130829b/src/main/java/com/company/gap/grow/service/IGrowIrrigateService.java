package com.company.gap.grow.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.grow.model.Irrigate;

public interface IGrowIrrigateService extends IBaseService<Irrigate> {
	public List<Irrigate> findByRegisterId(Integer registerId);
}

