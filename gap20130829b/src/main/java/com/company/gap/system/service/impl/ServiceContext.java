package com.company.gap.system.service.impl;

import com.company.gap.base.util.LocalHelper;
import com.company.gap.system.model.User;
import com.company.gap.system.service.UserSuportable;

public class ServiceContext implements UserSuportable {
	
	private static final ThreadLocal<User> user = LocalHelper.registStatic(new ThreadLocal<User>());
	
	public static void setUser(User user) {
		ServiceContext.user.set(user);
	}
	
	public static User getUser() {
		return user.get();
	}
	
	public static int getLoginId() {
		User user = getUser();
		if (user == null) return 0;
		return user.getId();
	}
	
	public static String getUserName() {
		return getUser().getUserName();
	}
}
