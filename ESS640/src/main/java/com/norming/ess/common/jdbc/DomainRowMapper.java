/**
 * Copyright (C) Norming Information Technology Co.,Ltd. 2012. All 
 * rights reserved.
 *
 * This software is covered by the license agreement between the end user and
 * Norming Information Technology Co.,LTD., and may be used and copied 
 * only in accordance with the terms of the said agreement.
 * 
 * Norming Information Science Co.,LTD. assumes no responsibility or 
 * liability for any errors or inaccuracies in this software, 
 * or any consequential, incidental or indirect damage arising out of the use 
 * of the software.
 */
package com.norming.ess.common.jdbc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;


/**
 * 实体与数据库映射
 * 
 * @author lirui 
 * @time jul 27,2012
 *
 */
public class DomainRowMapper implements RowMapper {
	/**
	 * 对象域的索引。key为对象类的全名加上配置文件中的column或alias属性。
	 */
	private static final Map<String, String> mapping = new HashMap<String, String>();

	/**
	 * 领域对象中领域对象域的索引。用于加速层叠封装。
	 */
	private static final Map<Class<?>, List<Field>> domainFields = new HashMap<Class<?>, List<Field>>();

	private static Log logger = LogFactory.getLog(DomainRowMapper.class);

	static {
		try {
			Document doc = DocumentHelper.parseText(loadXMLToString("mapping.xml"));
			List<?> beans = doc.selectNodes("//" + "bean");
			for (Iterator<?> iterator = beans.iterator(); iterator.hasNext();) {
				// 载入映射索引
				Element bean = (Element) iterator.next();
				String className = bean.attribute("class").getValue();

				Iterator<?> i = bean.elementIterator("property");
				while (i.hasNext()) {
					Element propertyElement = (Element) i.next();

					String name = propertyElement.attribute("name").getValue();
					String column = propertyElement.attribute("column")
							.getValue();
					mapping.put(className + column, name);

					Attribute alias = propertyElement.attribute("alias");
					if (alias != null)
						mapping.put(className + alias.getValue(), name);
				}

				// 载入领域对象域
				Class<?> clazz = Class.forName(className);
				domainFields.put(clazz, getDomainFields(clazz));
			}
		} catch (Exception e) {
			logger.info("配置文件错误,错误信息如下：【" + e.getMessage() + "】");
		}
	}

	/**
	 * 获取领域对象中的子领域对象域的列表。
	 * 
	 * @param clazz
	 *            需要被分析的领域对象的类对象
	 * @return 子领域对象域的列表
	 */
	private static List<Field> getDomainFields(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();

		Field[] allFields = clazz.getDeclaredFields();

		for (Field field : allFields) {
			if (field.getType().getName().contains("com.freadi.xflow.*.domain")) {
				field.setAccessible(true);
				fields.add(field);
			}
		}

		return fields;
	}

	/**
	 * 读取文件中的内容,并将它组合成字符串返回
	 * 
	 * @param fileName
	 *            配置文件名
	 * @return String 配置文件的字符串
	 */
	private static String loadXMLToString(String fileName) throws Exception {
		StringBuilder result = new StringBuilder();
		BufferedReader br = null;
		InputStream input = null;
		try {
			input = BeanFactory.class.getClassLoader().getResourceAsStream(
					fileName);
			br = new BufferedReader(new InputStreamReader(input));
			while (br.ready()) {
				String str = br.readLine();
				result = result.append(str);
			}
		} finally {
			if (br != null) {
				br.close();
				br = null;
			}
			if (input != null) {
				input.close();
				input = null;
			}
		}
		return result.toString();
	}

	/**
	 * 需要被封装的根对象的类对象
	 */
	private Class<?> clazz = null;

	/**
	 * 层叠封装的深度。该值为0时表示只有当前对象会被封装，而子对象不封装。
	 */
	private int casscadeDepth = 0;

	private ResultSet rs;
	private Map<String, Object> resultMap;

	/**
	 * 创建一个领域对象封装器。
	 * 
	 * @param clazz
	 *            需要被封装的根对象的类对象
	 */
	public DomainRowMapper(Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 创建一个领域对象封装器。
	 * 
	 * @param clazz
	 *            需要被封装的根对象的类对象
	 * @param casscadeDepth
	 *            指定层叠封装的深度。该值为0时表示只有当前对象会被封装，而子对象不封装。
	 */
	public DomainRowMapper(Class<?> clazz, int casscadeDepth) {
		this.clazz = clazz;
		this.casscadeDepth = casscadeDepth;
	}

	public Object mapRow(ResultSet rs, int para) throws SQLException {
		// 保存结果集对象。
		this.rs = rs;

		// 如果层叠深度大于0，则先把结果集转换成Map对象，以提高性能。
		if (casscadeDepth > 0) {
			if (resultMap == null)
				resultMap = new HashMap<String, Object>();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String key = JdbcUtils.lookupColumnName(rsmd, i);
				resultMap.put(key, JdbcUtils.getResultSetValue(rs, i));
			}
		}

		Object obj = create(this.clazz, casscadeDepth);

		// 封装完一行数据后必须清除Map的信息，否则可能会产生数据混乱。
		if (resultMap != null)
			resultMap.clear();

		return obj;
	}

	/**
	 * 将JDBC结果集中的记录转换成相应的对像
	 * 
	 * @param clazz
	 *            要封装的对象的类对象
	 * @param casscadeDepth
	 *            层叠封装的深度。该值为0时表示只有当前对象会被封装，而子对象不封装。
	 * @return 封装好的对象
	 */
	private Object create(Class<?> clazz, int casscadeDepth) {
		try {
			String className = clazz.getName();
			Object obj = null;

			// 如果结果集没有转换成Map对象，则直接从结果集中获取信息。
			if (resultMap == null) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					// 获取列的名称或别名。
					String columnName = JdbcUtils.lookupColumnName(rsmd, i);

					// 通过预先配置好的索引来获取对象域的名称。
					String fieldName = DomainRowMapper.mapping.get(className
							+ columnName);

					if (fieldName != null) {
						if (obj == null)
							obj = clazz.newInstance();

						Object value = JdbcUtils.getResultSetValue(rs, i);
						Field field = clazz.getDeclaredField(fieldName);
						// 将所有修饰符为private和protected的field都设为可以直接设值。
						field.setAccessible(true);
						field.set(obj, convertType(value, field.getType()));
					}
				}
			} else {
				Set<String> columnNames = resultMap.keySet();

				for (String columnName : columnNames) {
					String fieldName = DomainRowMapper.mapping.get(className
							+ columnName);

					if (fieldName != null) {
						if (obj == null)
							obj = clazz.newInstance();

						Object value = resultMap.get(columnName);
						Field field = clazz.getDeclaredField(fieldName);
						field.setAccessible(true);
						field.set(obj, convertType(value, field.getType()));
					}
				}
			}

			// 如果层叠参数大于0，则继续封装当前对象的子对象。
			if (casscadeDepth > 0) {
				List<Field> domainFields = DomainRowMapper.domainFields
						.get(clazz);

				for (Field field : domainFields) {
					Object subObj = create(field.getType(), casscadeDepth - 1);
					field.set(obj, subObj);
				}
			}

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 转换数据类型
	 * 
	 * @param obj
	 *            需要被转换的对象
	 * @param clazz
	 *            要被转成的类型
	 * @return 转换类型后的数据
	 */
	private Object convertType(Object obj, Class<?> clazz) {
		if (obj == null || obj.getClass().equals(clazz)) {
			return obj;
		} else if (obj.getClass().equals(BigDecimal.class)) {
			if (clazz.equals(Integer.class))
				return ((BigDecimal) obj).intValue();
			else if (clazz.equals(Double.class))
				return ((BigDecimal) obj).doubleValue();
			else if (clazz.equals(Long.class))
				return ((BigDecimal) obj).longValue();
			else
				return ((BigDecimal) obj).floatValue();
		} else {
			throw new RuntimeException("缺少类型转换的映射！需要被转换的对象的类型为："
					+ obj.getClass().getName() + ";期望被转换的类型为："
					+ clazz.getName() + "。");
		}
	}
}
