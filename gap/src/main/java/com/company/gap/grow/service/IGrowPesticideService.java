package com.company.gap.grow.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.grow.model.Pesticide;

public interface IGrowPesticideService extends IBaseService<Pesticide> {
	public List<Pesticide> findByRegisterId(Integer registerId);
}
