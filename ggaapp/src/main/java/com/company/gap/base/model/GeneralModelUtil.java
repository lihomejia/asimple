package com.company.gap.base.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.company.gap.base.util.FieldPropertyConvert;
import com.company.gap.base.util.sql.SqlResult;

/**
 * 
 * @author lh.jia
 *
 */
public class GeneralModelUtil {
	public static final String COMMA = ",";
	public static final String AND = " AND ";
	

	/**
	 * 持久化对象，并返回新对象的主键.
	 * @param jdbcTemplate
	 * @param model
	 * @return
	 */
	public static int insert(JdbcTemplate jdbcTemplate, Object model) {
		SqlResult result = getInsertSql(model);
		
		final String sql = result.getSql();
		final Object[] os = result.getValues();
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < os.length; i++) {
					ps.setObject(i + 1, os[i]);
				}
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}
	
	/**
	 * 更新对象，并返回影响行数
	 * @param jdbcTemplate
	 * @param model
	 * @return
	 */
	public static int update(JdbcTemplate jdbcTemplate, Object model) {
		SqlResult result = getUpdateSql(model);
		return jdbcTemplate.update(result.getSql(), result.getValues());
	}
	
	public static SqlResult getInsertSql(Object model) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ").append(getTableName(model)).append(" (");

		StringBuffer fields 	= new StringBuffer();
		StringBuffer feilds2 	= new StringBuffer();
		List<Object> values 	= new ArrayList<Object>();
		for (Class<?> c = model.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String column = FieldPropertyConvert.propertyToField(f.getName());
				Object value = null;
				try {
					value = f.get(model);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {}
				
				if (!isUsefulField(column, value)) continue;

				fields.append(COMMA).append(column);
				feilds2.append(COMMA).append("?");
				values.add(value);
			}
		}
		if (fields.length() > 0)
			fields.delete(0, COMMA.length());
		if (feilds2.length() > 0)
			feilds2.delete(0, COMMA.length());

		sql.append(fields).append(") values (").append(feilds2).append(")");

		return new SqlResult(sql.toString(), values.toArray(new Object[values.size()]));
	}
	

	public static SqlResult getUpdateSql(Object model) {
		StringBuffer sql = new StringBuffer();
		sql.append("update ").append(getTableName(model)).append(" set ");

		StringBuffer fields = new StringBuffer();
		StringBuffer keys 	= new StringBuffer();
		List<Object> fvalues= new ArrayList<Object>();
		List<Object> kvalues= new ArrayList<Object>();
		for (Class<?> c = model.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String column = FieldPropertyConvert.propertyToField(f.getName());
				Object value = null;
				try {
					value = f.get(model);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {}
				
				if (!isUsefulField(column, value)) continue;

				if ("id".equals(column)) {
					keys.append(AND).append(column).append("=?");
					kvalues.add(value);
				} else {
					fields.append(COMMA).append(column).append("=?");
					fvalues.add(value);
				}
			}
		}
		if (fields.length() > 0) {
			fields.delete(0, COMMA.length());
			sql.append(fields);
		}
		if (keys.length() > 0) {
			keys.delete(0, AND.length());
			sql.append(" where ").append(keys);
		}
		
		fvalues.addAll(kvalues);
		return new SqlResult(sql.toString(), fvalues.toArray(new Object[fvalues.size()]));
	}
	
	public static SqlResult getSelectSql(Object model) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ").append(getTableName(model));
		
		StringBuffer conditions = new StringBuffer();
		List<Object> values= new ArrayList<Object>();
		for (Class<?> c = model.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String column = FieldPropertyConvert.propertyToField(f.getName());
				Object value = null;
				try {
					value = f.get(model);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {}
				
				if (!isUsefulField(column, value)) continue;
				
				conditions.append(AND).append(column).append("=?");
				values.add(value);
			}
		}
		if (conditions.length() > 0) {
			conditions.delete(0, AND.length());
			sql.append(" where ").append(conditions);
		}
		
		return new SqlResult(sql.toString(), values.toArray(new Object[values.size()]));
	}
	
	public static String toString(Object model) {
		Map<String, Object> m = new HashMap<String, Object>();
		for (Class<?> c = model.getClass(); c != Object.class; c = c.getSuperclass()) {
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				String n = f.getName();
				Object v = null;
				try {
					v = f.get(model);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {}
				
				if (v == null) continue;

				m.put(n, v);
			}
		}
		return m.toString();
	}
	
	public static String getTableName(Class<?> clazz) {
		Entity entity = clazz.getAnnotation(Entity.class);
		if (entity != null) {
			return entity.name();
		}
		return null;
	}

	public static String getTableName(Object model) {
		return getTableName(model.getClass());
	}
	
	private static boolean isUsefulField(String field, Object value) {
		return value != null && !"__disp".equals(field); 
	}
}