package com.company.gap.cinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.base.util.sql.SqlUtils;
import com.company.gap.cinfo.dao.ICinfoDao;
import com.company.gap.cinfo.enumeration.CinfoType;
import com.company.gap.cinfo.model.Cinfo;

@Repository
public class CinfoDaoImpl extends BaseDaoImpl<Cinfo> implements ICinfoDao<Cinfo> {
	
	private static String UNION_ALL = " union all ";

	@Override
	public List<Cinfo> queryGroup(CinfoType[] types) {
		
		StringBuffer sb = new StringBuffer();
		
		for (CinfoType type : types) {
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
