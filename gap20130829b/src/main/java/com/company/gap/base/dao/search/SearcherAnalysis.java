package com.company.gap.base.dao.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.company.gap.base.util.sql.SqlResult;

public class SearcherAnalysis {

	static String SQL_SELECT 	= "SELECT * ";
	static String SQL_FROM 		= " FROM ";
	static String SQL_AND 		= " AND ";
	static String SQL_WHERE 	= " WHERE ";
	static String SQL_ORDERBY 	= " ORDER BY ";
	static String SQL_GROUPBY 	= " GROUP BY ";
	
	public static String getSelectFromSimpleSearcher(SimpleSearcher searcher) {
		String select = searcher.getSelect();
		if (StringUtils.isEmpty(select)) select = SQL_SELECT;
		return select;
	}
	
	
	public static SqlResult getWhereFromSimpleSearcher(SimpleSearcher searcher) {
		if (searcher.getSfs() == null || searcher.getSfs().size() == 0) {
			if (StringUtils.isEmpty(searcher.getAddsql())) {
				return new SqlResult("", new Object[0]);
			}
			return new SqlResult(SQL_WHERE + searcher.getAddsql(), new Object[0]);
		}
	
		StringBuilder sql = new StringBuilder();
		List<Object> pros = new ArrayList<Object>();
		
		List<SearchField> sfs = new ArrayList<SearchField>(searcher.getSfs().size() * 2);
		for (SearchField sf : searcher.getSfs().values()){
			if (StringUtils.isEmpty(sf.getName())){
				// nothing to do
			}
			else if (Op.BT.equals(sf.getOp())){
				if (!StringUtils.isEmpty(sf.getValue())){
					sfs.add(new SearchField(sf.getName(), Op.GE, sf.getValue()));
				}
				if (!StringUtils.isEmpty(sf.getValue2())){
					sfs.add(new SearchField(sf.getName(), Op.LE, sf.getValue2()));
				}
			} 
			else if (StringUtils.isEmpty(sf.getValue())){
				
			} 
			else {
				sfs.add(sf);
			}
		}
		
		for (SearchField sf : sfs){
			Op op = sf.getOp();
			
			String name = sf.getName();
			name = name.replace('.', '_');
			String value = sf.getValue();
			
			if (value == null){
				continue;
			}
			
			String sFieldName=sf.getName();
			
			// 如果是like表达式,则自动增加%
			if (op.equals(Op.STARTSWITH)){
				value = value + "%";
			} else if (op.equals(Op.ENDSWITH)){
				value = "%" + value;
			} else if (op.equals(Op.CONTAINS)){
				value = "%" + value + "%";
			}
			
			sql.append(SQL_AND).append(sFieldName).append(" ").append(op.getOper());
			
			if (Op.IN.equals(op)){
				Object[] vals = value.split(";");
				sql.append("(?");
				pros.add(vals[0]);
				for (int i = 1; i < vals.length; i++) {
					sql.append(",?");
					pros.add(vals[i]);
				}
				sql.append(")");
			} else {
				sql.append(" ?");
				pros.add(value);
			}
		}
		
		if (sql.indexOf(SQL_AND) == 0){
			sql.delete(0, SQL_AND.length());
		}
		
		if (!StringUtils.isEmpty(searcher.getAddsql())){
			sql
				.append(sql.length() > 0 ? SQL_AND : "")
				.append("(")
				.append(searcher.getAddsql())
				.append(")")
			;
		}
		if (sql.length() > 0) sql.insert(0, SQL_WHERE);
		
		return new SqlResult(sql.toString(), pros.toArray(new Object[0]));
	}
	
	public static String getGroupByFromSimpleSearcher(SimpleSearcher searcher) {
		
		if (StringUtils.isEmpty(searcher.getGroup())) return "";
		
		return SQL_GROUPBY + searcher.getGroup();
	}
	
	public static String getOrderByFromSimpleSearcher(SimpleSearcher searcher) {
		
		if (searcher.getOrders().size() == 0) return "";
		
		return SQL_ORDERBY + searcher.calOrderBy();
		
	}
	
}
