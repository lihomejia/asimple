package com.company.gap.base.util.sql;

import java.io.Serializable;

public class SqlResult implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 预处理的SQL语句 */
	private String sql;
	
	/** 预处理SQL真实的值列表 */
	private Object[] values;
	
	public SqlResult(String sql, Object[] values) {
		super();
		this.sql = sql;
		this.values = values;
	}
	
	public String getSql() {
		return sql;
	}

	public Object[] getValues() {
		return values;
	}

}