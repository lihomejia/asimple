package com.company.gap.system.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.system.model.User;

public interface IUserService extends IBaseService<User> {
	
	String findNameById(Integer id);
}
