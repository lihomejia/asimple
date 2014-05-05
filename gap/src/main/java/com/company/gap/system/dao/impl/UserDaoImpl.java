package com.company.gap.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.base.model.GeneralModelUtil;
import com.company.gap.base.util.DynamicDataSource;
import com.company.gap.base.util.sql.SqlResult;
import com.company.gap.system.dao.IUserDao;
import com.company.gap.system.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Override
	public List<User> findList(String companyId, User u) {
		
		DataSource ds = new DynamicDataSource().getDataSourceByCompanyId(companyId);
		if (ds == null) {
			return new ArrayList<>();
		}
		JdbcTemplate jdbcTemplateTmp = new JdbcTemplate(ds);

		SqlResult result = GeneralModelUtil.getSelectSql(u);
		
		
		return jdbcTemplateTmp.query(result.getSql(), new BeanPropertyRowMapper<User>(clazz), result.getValues());
	}

}
