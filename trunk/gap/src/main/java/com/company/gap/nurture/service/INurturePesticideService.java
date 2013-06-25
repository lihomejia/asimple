package com.company.gap.nurture.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.nurture.model.Pesticide;

public interface INurturePesticideService extends IBaseService<Pesticide> {
	public List<Pesticide> findByRegisterId(Integer registerId);
}
