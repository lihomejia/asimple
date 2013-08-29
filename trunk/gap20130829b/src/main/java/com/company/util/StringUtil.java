package com.company.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * StringBuilder的初始化大小,设置的大点,
	 */
	public static int SB_BUF_SIZE = 1000;
	
	private static Pattern mapPattern = Pattern.compile("(\\{:)([^\\}]+)(\\})");
	
	public static String format(String src, Map<String, Object> pars) {
		StringBuilder sb = new StringBuilder(SB_BUF_SIZE);
		Matcher matcher = mapPattern.matcher(src);
		int pos = 0;

		while (matcher.find(pos)) {
			sb.append(src.substring(pos, matcher.start(1)));
			String tag = src.substring(matcher.start(2), matcher.end(2));
			Object value = pars.get(tag);
			if (value == null) {
				sb.append("{:").append(tag).append('}');
			}
			else {
				sb.append(value);
			}

			pos = matcher.end(3);
		}

		sb.append(src.substring(pos));

		return sb.toString();
	}
}
