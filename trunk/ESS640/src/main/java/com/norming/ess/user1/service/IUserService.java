package com.norming.ess.user1.service;

import java.util.List;

import com.norming.ess.user1.model.User;

public interface IUserService {
	
	String BEAN_NAME= "userService";
	
	List<User> findAll();
	
	User findUserById(String id);
	
	int editUser(User user);
	
	int addUser(User user);
	
	int deleteUser(String id);
}
