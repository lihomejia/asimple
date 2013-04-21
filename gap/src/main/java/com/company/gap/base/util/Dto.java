package com.company.gap.base.util;

import java.util.Date;
import java.util.Map;

public interface Dto extends Map<String, Object> {
	
	String getString(String key);
	
	int getInt(String key);
	
	double getDouble(String key);
	
	Date getDate(String key);
	
}