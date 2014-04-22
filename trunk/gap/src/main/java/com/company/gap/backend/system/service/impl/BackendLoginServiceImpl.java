package com.company.gap.backend.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.backend.system.dao.IBackendLoginDao;
import com.company.gap.backend.system.service.IBackendLoginService;
import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.system.model.User;

@Service
public class BackendLoginServiceImpl extends BaseServiceImpl<User> implements IBackendLoginService {

	@Autowired
	private IBackendLoginDao dao;
	
	@Override
	protected IBaseDao<User> get() {
		return this.dao;
	}

}
