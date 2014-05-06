package com.company.gap.info.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.base.util.sql.SqlUtils;
import com.company.gap.info.dao.IInfoDao;
import com.company.gap.info.enumeration.InfoType;
import com.company.gap.info.model.Info;

@Repository
public class InfoDaoImpl extends BaseDaoImpl<Info> implements IInfoDao<Info> {
	
	private static String UNION_ALL = " union all ";
	
	@Resource(name="jdbcTemplateCommon")
	protected JdbcTemplate jdbcTemplateCommon;
	
	protected JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplateCommon;
	}

	@Override
	public List<Info> queryGroup(InfoType[] types) {
		
		StringBuffer sb = new StringBuffer();
		
		for (InfoType type : types) {
			sb.append(UNION_ALL);
			
			String sql = "select * from " + getTableName() + " where type='" + type + "'";
			
			sb.append("(").append(SqlUtils.toPagerSql(sql, 1, 15)).append(")");
		}
		
		if (sb.length() > 0) {
			sb.delete(0, UNION_ALL.length());
		}
		
		return this.findList(sb.toString());
	}
}
