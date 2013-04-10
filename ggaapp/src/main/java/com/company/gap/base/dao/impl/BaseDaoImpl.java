package com.company.gap.base.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.company.gap.base.dao.IBaseDao;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	public static final String COMMA = ",";
	public static final String AND = " AND ";
	
	@Override
	public int insert(T t) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into $Table$ (");

		StringBuffer fs = new StringBuffer();
		StringBuffer vs = new StringBuffer();
		List<Object> os = new ArrayList<Object>();
		for (Class c = t.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String n = f.getName();
				Object v = null;
				try {
					v = f.get(t);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {}
				
				if (v == null || "__disp".equals(n))
					continue;

				fs.append(COMMA).append(n);
				vs.append(COMMA).append("?");
				os.add(v);
			}
		}
		if (fs.length() > 0)
			fs.delete(0, COMMA.length());
		if (vs.length() > 0)
			vs.delete(0, COMMA.length());

		sql.append(fs).append(") values (").append(vs).append(")");

		
		return 0;
	}

	@Override
	public int update(T t) {
		StringBuffer sql = new StringBuffer();
		sql.append("update $Table$ set ");

		StringBuffer fs = new StringBuffer();
		StringBuffer ks = new StringBuffer();
		List<Object> os = new ArrayList<Object>();
		for (Class c = t.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String n = f.getName();
				Object v = null;
				try {
					v = f.get(t);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {}
				
				if (v == null || "__disp".equals(n))
					continue;

				if ("id".equals(n)) {
					ks.append(AND).append(n).append("=?");
				} else {
					fs.append(COMMA).append(n).append("=?");
				}
				os.add(v);
			}
		}
		if (fs.length() > 0)
			fs.delete(0, COMMA.length());
		if (ks.length() > 0)
			ks.delete(0, AND.length());

		sql.append(fs).append(" where ").append(ks);
		return 0;
	}
	
	

}
