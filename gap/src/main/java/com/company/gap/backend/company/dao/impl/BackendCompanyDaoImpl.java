package com.company.gap.backend.company.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.backend.company.dao.IBackendCompanyDao;
import com.company.gap.backend.company.model.Company;
import com.company.gap.base.GapConstants;
import com.company.gap.base.InitDynamicDataSource;
import com.company.gap.base.SpringContextHolder;
import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.base.model.GeneralModelUtil;
import com.company.gap.base.util.DynamicDataSource;
import com.company.gap.base.util.sql.SqlResult;

@Repository
public class BackendCompanyDaoImpl extends BaseDaoImpl<Company> implements IBackendCompanyDao {

	@Resource(name="jdbcTemplateCommon")
	protected JdbcTemplate jdbcTemplate;
	
	
	@Resource(name="jdbcTemplate")
	protected JdbcTemplate jdbcTemplateTmp;
	
	
	@Override
	public boolean initCompanyDatabase(Integer id) {
		
		Company c = findById(id);
		
		try {
			//create database
			jdbcTemplate.execute("CREATE DATABASE " + GapConstants.SCHEMA_PREFIX + c.getInnercode() + " DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci");
		} catch (Exception e) {
			
		}
		
		List<Map<String, Object>> comList = new ArrayList<>();
		
		Map<String, Object> mCompany = new HashMap<>();
		mCompany.put("innercode", c.getInnercode());
		comList.add(mCompany);
		
		InitDynamicDataSource idds = SpringContextHolder.getBean(InitDynamicDataSource.class);
		idds.loadCompanyDataSource(comList);
		
		jdbcTemplateTmp = new JdbcTemplate(new DynamicDataSource().getDataSourceByCompanyId(String.valueOf(c.getInnercode())));
		
		String[] scripts = new String[] {"createtables-company.sql", "initdata-company.sql"};
		
		for (String script : scripts) {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("rs/scripts/" + script);
			
			BufferedReader reader;
			try {
				reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
				StringBuffer sb=new StringBuffer();
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				
				for (String sql : StringUtils.split(sb.toString(), ";")) {
					if (!StringUtils.isBlank(sql)) {
						jdbcTemplateTmp.execute(sql);
					}
				}
				
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		jdbcTemplateTmp.execute("update t_user set user_id='admin@" + c.getCompanyno() + "'");
		
		return true;
	}


	@Override
	public Company findCompanyByCompanyNo(String companyNo) {
		Company temp = new Company();
		temp.setCompanyno(companyNo);
		
		SqlResult result = GeneralModelUtil.getSelectSql(temp);
		
		List<Company> l = jdbcTemplate.query(result.getSql(), new BeanPropertyRowMapper<Company>(clazz), result.getValues());
		
		return l.size() > 0 ? l.get(0) : null;
	}
	
	
}