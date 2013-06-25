package com.company.gap.nurture.service;

import java.util.List;

import com.company.gap.base.service.IBaseService;
import com.company.gap.nurture.model.Farm;

public interface INurtureFarmService extends IBaseService<Farm> {
	
	public List<Farm> findByRegisterId(Integer registerId);
}
