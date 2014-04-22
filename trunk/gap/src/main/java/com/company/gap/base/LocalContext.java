package com.company.gap.base;

import com.company.gap.base.util.LocalHelper;
import com.company.gap.system.model.User;

public class LocalContext {
private static final ThreadLocal<User> user = LocalHelper.registStatic(new ThreadLocal<User>());
	
	public static void setUser(User user) {
		LocalContext.user.set(user);
	}
	
	public static User getUser() {
		return user.get();
	}
	
	public static String getCompanyId() {
	    User user = getUser();
        return user == null ? null : user.getCompanyId();
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
