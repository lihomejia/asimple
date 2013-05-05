package com.company.gap.base.component;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.util.New;
import com.company.util.StringUtil;

public class TranslatorImplOnDb extends AbstractTranslator<Integer, String> {
	private String table, keyField, valueField;
	
	
	private final static String tpl 	= "select {:valueField} from {:table} where {:keyField} = ?";
	private final static String tplIn 	= "select {:keyField}, {:valueField} from {:table} where {:keyField} in {:keyValues}";
	
	private Map<String, Object> values = null;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TranslatorImplOnDb(String table, String keyField, String valueField) {
		super();
		this.table = table;
		this.keyField = keyField;
		this.valueField = valueField;
		
		this.values = New.hashMap();
		this.values.put("table", 		this.table);
		this.values.put("keyField", 	this.keyField);
		this.values.put("valueField", 	this.valueField);
	}


	@Override
	public String translate(Integer key) {
		List<Dto> list = jdbcTemplate.query(fromTemplate(tpl, this.values), new ColumnDtoRowMapper(), key);
		
		if (list.size() == 0) return null;
		
		return list.get(0).getString(valueField);
	}

	@Override
	public List<String> translate(List<Integer> keys) {
		List<String> ret = New.arrayList();
		
		int size = keys.size();
		if (size == 0) return ret;
		if (size == 1) {
			ret.add(this.translate(keys.get(0)));
			return ret;
		}

		StringBuffer keyValues = new StringBuffer();
		keyValues.append("(");
		Object[] pros = new Object[size];
		for (int i = 0; i < size; i++) {
			pros[i] = keys.get(i);
			keyValues.append(",?");
		}
		keyValues.append(")").delete(1, 2);
		
		this.values.put("keyValues", keyValues.toString());
		
		List<Dto> datas = jdbcTemplate.query(fromTemplate(tplIn, this.values), new ColumnDtoRowMapper(), pros);
		Map<Integer, String> key2Value = New.hashMap();
		for (Dto data : datas) {
			key2Value.put(data.getInt(this.keyField), data.getString(this.valueField));
		}
		
		for (Integer key : keys) {
			ret.add(key2Value.get(key));
		}
		
		return ret;
	}
	
	private final static String fromTemplate(String tpl, Map<String, Object> values){
		return StringUtil.format(tpl, values);
	}
}