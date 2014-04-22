package com.company.gap.backend.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.backend.system.dao.IBackendUserDao;
import com.company.gap.backend.system.service.IBackendUserService;
import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.system.model.User;

@Service
public class BackendUserServiceImpl extends BaseServiceImpl<User> implements IBackendUserService {

	@Autowired
	private IBackendUserDao dao;
	
	@Override
	protected IBaseDao<User> get() {
		return this.dao;
	}

	@Override
	public String findNameById(Integer id) {
		User t = this.findById(id);
		if (t == null) return null;
		return t.getUserName();
	}

	
}
