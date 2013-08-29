package com.company.gap.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.system.dao.ILoginDao;
import com.company.gap.system.model.User;
import com.company.gap.system.service.ILoginService;

@Service
public class LoginServiceImpl extends BaseServiceImpl<User> implements ILoginService {

	@Autowired
	private ILoginDao dao;
	
	@Override
	protected IBaseDao<User> get() {
		return this.dao;
	}

}
