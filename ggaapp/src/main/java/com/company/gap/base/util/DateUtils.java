package com.company.gap.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;


public class DateUtils {
	/**
	 * 系统默认的DateFormay格式 
	 */
	public static final String DEFAULT_SDF = "yyyy-MM-dd";
	
	public static SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_SDF);
	
	public static String format(Date date) {
		if (date == null) return "";
		return sdf.format(date);
	}
	
	public static String format(Object date) {
		if (date instanceof Date) return format((Date) date);
		return "";
	}
	
	public static Date parse(String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static Date parse(Object date) {
		return parse(ObjectUtils.toString(date));
	}
	
	
}
