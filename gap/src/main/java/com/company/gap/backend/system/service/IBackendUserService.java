package com.company.gap.backend.system.service;

import com.company.gap.base.service.IBaseService;
import com.company.gap.system.model.User;

public interface IBackendUserService extends IBaseService<User> {
	
	String findNameById(Integer id);
}
