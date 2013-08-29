package com.company.gap.base.util;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseTestCase {
	
	public static JdbcTemplate jdbcTemplate;
	
	static {
		Properties ps = new Properties();
		try {
			ps.load(BaseTestCase.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(ps.getProperty("jdbc.driver"));
		dataSource.setUrl(ps.getProperty("jdbc.url"));
		dataSource.setUsername(ps.getProperty("jdbc.username"));
		dataSource.setPassword(ps.getProperty("jdbc.password"));
	
		jdbcTemplate = new JdbcTemplate(dataSource);
	}	
}