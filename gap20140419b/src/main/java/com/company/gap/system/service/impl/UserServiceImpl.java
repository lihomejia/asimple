package com.company.gap.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.system.dao.IUserDao;
import com.company.gap.system.model.User;
import com.company.gap.system.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

	@Autowired
	private IUserDao dao;
	
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
