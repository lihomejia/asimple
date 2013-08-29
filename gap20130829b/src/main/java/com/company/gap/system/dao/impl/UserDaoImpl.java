package com.company.gap.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.system.dao.IUserDao;
import com.company.gap.system.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

}
