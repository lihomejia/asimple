package com.company.gap.base.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class BaseDto extends HashMap<String, Object> implements Dto {

	private static final long serialVersionUID = 1L;

	public BaseDto() {
		super();
	}

	public BaseDto(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public BaseDto(int initialCapacity) {
		super(initialCapacity);
	}

	public BaseDto(Map<? extends String, ? extends Object> m) {
		super(m);
	}

	@Override
	public String getString(String key) {
		return ObjectUtils.toString(this.get(key));
	}
	
	@Override
	public int getInt(String key) {
		Object value = this.get(key);
		if (value instanceof Integer) return (Integer) value;
		return NumberUtils.toInt(ObjectUtils.toString(value));
	}
	
	@Override
	public double getDouble(String key) {
		Object value = this.get(key);
		if (value instanceof Number) return ((Number) value).doubleValue();
		return NumberUtils.toDouble(ObjectUtils.toString(value));
	}
	
	@Override
	public Date getDate(String key) {
		Object value = this.get(key);
		if (value instanceof Date) return (Date) value;
		return DateUtils.parse(value);
	}
}
