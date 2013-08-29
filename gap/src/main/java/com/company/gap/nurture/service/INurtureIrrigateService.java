package com.company.gap.nurture.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.nurture.model.Irrigate;

public interface INurtureIrrigateService extends IBaseService<Irrigate> {
	public List<Irrigate> findByRegisterId(Integer registerId);
}

