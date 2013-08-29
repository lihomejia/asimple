package com.company.gap.comp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.comp.dao.ICompDao;
import com.company.gap.comp.model.Comp;
import com.company.gap.comp.service.ICompService;

@Service
public class CompServiceImpl extends BaseServiceImpl<Comp> implements ICompService {
	
	@Autowired
	private ICompDao<Comp> dao;
	
	protected IBaseDao<Comp> get() {
		return this.dao;
	}
}
