package com.company.gap.base.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import com.company.gap.base.LocalContext;
import com.company.gap.base.SpringContextHolder;

/**
 * 动态切换数据源的装饰者类.
 * @author lh.jia
 *
 */
public class DynamicDataSource implements DataSource {
	
	
	/**
	 * 数据源集合.
	 * 采用JAVA自己实现的HashMap存储，而非采用Spring对Bean的管理.
	 */
	private Map<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();
	/**
	 * 得到真正的数据源信息.
	 * @return
	 */
	private DataSource getDataSource() {
		/**
		 * 注意:这里以dataSoruce 加上当前登录用户所在的Company ID当作数据源的ID,所以ID的命名必须规范.
		 */
		return this.getDataSourceByCompanyId(LocalContext.getCompanyId());
	}
	
	/**
	 * @param companyId
	 * @return DataSource 
	 */
	public DataSource getDataSourceByCompanyId(String companyId) {
		return this.getDataSource("dataSource" + StringUtils.defaultString(companyId));
	}
	
	/**
	 * 得到真正的数据源信息.
	 */
	private DataSource getDataSource(String dataSourceName) {
		DataSource dataSource = dataSourceMap.get(dataSourceName);
		
		if (dataSource != null) return dataSource;
		
		try {
			dataSource = SpringContextHolder.getBean(dataSourceName);
		} catch (Exception e) {
			
		}
		if (dataSource != null) {
			dataSourceMap.put(dataSourceName, dataSource);
		}
		return dataSource;
	}
	

	/*
	 * (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection()
	 */
	@Override
	public Connection getConnection() throws SQLException {
		return this.getDataSource().getConnection();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
	 */
	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		return this.getDataSource().getConnection(username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 */
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return this.getDataSource().getLogWriter();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLoginTimeout()
	 */
	@Override
	public int getLoginTimeout() throws SQLException {
		return this.getDataSource().getLoginTimeout();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
	 */
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		this.getDataSource().setLogWriter(out);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLoginTimeout(int)
	 */
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		this.getDataSource().setLoginTimeout(seconds);
	}

	/*
	 * (non-Javadoc)
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return this.getDataSource().isWrapperFor(iface);
	}

	/*
	 * (non-Javadoc)
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return this.getDataSource().unwrap(iface);
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return this.getDataSource().getParentLogger();
	}
}