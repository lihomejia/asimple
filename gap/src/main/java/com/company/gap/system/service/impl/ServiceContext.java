package com.company.gap.system.service.impl;

import com.company.gap.base.util.LocalHelper;
import com.company.gap.system.model.User;
import com.company.gap.system.service.UserSuportable;

public class ServiceContext implements UserSuportable {
	
	private static final ThreadLocal<User> user = LocalHelper.registStatic(new ThreadLocal<User>());
	
	public static void setUser(User user) {
		ServiceContext.user.set(user);
	}
	
	@Override
	public User getUser() {
		return user.get();
	}
}
