package com.company.gap.grow.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.grow.model.Manure;

public interface IGrowManureService extends IBaseService<Manure> {
	public List<Manure> findByRegisterId(Integer registerId);
}
