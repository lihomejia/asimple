package com.norming.ess.user1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norming.ess.user1.dao.IUserDao;
import com.norming.ess.user1.model.User;
import com.norming.ess.user1.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	public int addUser(User user) {
		return userDao.insert(user);
	}

	public int editUser(User user) {
		return userDao.update(user);
	}

	public List<User> findAll() {
		return userDao.selectAll();
	}

	public User findUserById(String id) {
		return userDao.selectById(id);
	}

	@Override
	public int deleteUser(String id) {
		
		return userDao.deleteUser(id);
	}

}
