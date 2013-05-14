package com.company.gap.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.info.dao.IInfoDao;
import com.company.gap.info.model.Info;
import com.company.gap.info.service.IInfoService;

@Service
public class InfoServiceImpl extends BaseServiceImpl<Info> implements IInfoService {

	@Autowired
	private IInfoDao<Info> dao;
	
	protected IBaseDao<Info> get() {
		return this.dao;
	}

}
