package com.norming.ess.framework.service.impl;

import org.springframework.stereotype.Service;

import com.norming.ess.base.util.LocalHelper;
import com.norming.ess.framework.service.UserSuportable;
import com.norming.ess.user1.model.User;

@Service
public class ServiceContext implements UserSuportable {
	
	private static final ThreadLocal<User> user = LocalHelper.registStatic(new ThreadLocal<User>());
	
	public static void setUser(User user) {
		ServiceContext.user.set(user);
	}
	
	public User getUser() {
		return user.get();
	}

}
