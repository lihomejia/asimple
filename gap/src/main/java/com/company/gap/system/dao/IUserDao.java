package com.company.gap.system.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.system.model.User;

public interface IUserDao extends IBaseDao<User> {

	List<User> findList(String companyId, User u);
}
