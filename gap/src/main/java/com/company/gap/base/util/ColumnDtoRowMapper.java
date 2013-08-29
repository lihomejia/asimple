package com.company.gap.base.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class ColumnDtoRowMapper implements RowMapper<Dto> {

	public Dto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Dto dto = new BaseDto(columnCount);
		for (int i = 1; i <= columnCount; i++) {
			String key = JdbcUtils.lookupColumnName(rsmd, i);
			Object obj = JdbcUtils.getResultSetValue(rs, i);
			dto.put(key, obj);
		}
		return dto;
	}
}
