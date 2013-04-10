package com.company.gap.base.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import org.springframework.jdbc.core.JdbcTemplate;

import com.company.gap.base.util.sql.SqlResult;

/**
 * 
 * @author lh.jia
 *
 */
public class EntityUtil {
	public static final String COMMA = ",";
	public static final String AND = " AND ";
	
	public static SqlResult getInsertSql(GeneralModel model) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ").append(getTableName(model)).append(" (");

		StringBuffer fs = new StringBuffer();
		StringBuffer vs = new StringBuffer();
		List<Object> os = new ArrayList<Object>();
		for (Class<?> c = model.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String n = f.getName();
				Object v = null;
				try {
					v = f.get(model);
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

		return new SqlResult(sql.toString(), os.toArray(new Object[os.size()]));
	}
	

	public static SqlResult getUpdateSql(GeneralModel model) {
		StringBuffer sql = new StringBuffer();
		sql.append("update ").append(getTableName(model)).append(" set ");

		StringBuffer fs = new StringBuffer();
		StringBuffer ks = new StringBuffer();
		List<Object> os = new ArrayList<Object>();
		for (Class<?> c = model.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String n = f.getName();
				Object v = null;
				try {
					v = f.get(model);
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
		
		return new SqlResult(sql.toString(), os.toArray(new Object[os.size()]));
	}
	
	public static int insert(JdbcTemplate jdbcTemplate, GeneralModel model) {
		SqlResult result = getInsertSql(model);
		return jdbcTemplate.update(result.getSql(), result.getValues());
	}
	
	public static int update(JdbcTemplate jdbcTemplate, GeneralModel model) {
		SqlResult result = getUpdateSql(model);
		return jdbcTemplate.update(result.getSql(), result.getValues());
	}

	private static String getTableName(GeneralModel model) {
		Table table = model.getClass().getAnnotation(Table.class);
		if (table != null) {
			return table.name();
		}
		return null;
	}
}