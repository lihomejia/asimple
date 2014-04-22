package com.company.gap.backend.system.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.backend.system.dao.IBackendLoginDao;
import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.system.model.User;

@Repository
public class BackendLoginDaoImpl extends BaseDaoImpl<User> implements IBackendLoginDao {
	@Resource(name="jdbcTemplateCommon")
	protected JdbcTemplate jdbcTemplate;
}
