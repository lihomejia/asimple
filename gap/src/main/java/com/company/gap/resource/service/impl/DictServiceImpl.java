package com.company.gap.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.resource.dao.IDictDao;
import com.company.gap.resource.model.Dict;
import com.company.gap.resource.service.IDictService;

@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements IDictService {

	@Autowired
	private IDictDao dao;
	
	@Override
	protected IBaseDao<Dict> get() {
		return this.dao;
	}
}
