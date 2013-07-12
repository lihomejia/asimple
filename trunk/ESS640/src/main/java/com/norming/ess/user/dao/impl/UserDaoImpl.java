package com.norming.ess.user.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.norming.ess.common.dao.impl.CommonDaoImpl;
import com.norming.ess.user.dao.IUserDao;
import com.norming.ess.user.domain.User;

public class UserDaoImpl extends CommonDaoImpl implements IUserDao {
	
	public List<User> selectAll() {
		String querySql = "select ASUSER_USERID, ASUSER_USERNAME, ASUSER_EMAIL, ASUSER_PWD from ASUSER";
		return getJdbcTemplate().query(querySql, new BeanPropertyRowMapper<User>(User.class));
	}
	
	public User selectById(String id) {
		String querySql = "select ASUSER_USERID,ASUSER_USERNAME,ASUSER_EMAIL, ASUSER_PWD from ASUSER where ASUSER_USERID = ?";
		return getJdbcTemplate().queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class),id);
	}
	
	public int insert(User user) {
		String insertSql = "INSERT INTO ASUSER (ASUSER_USERID,ASUSER_USERNAME,ASUSER_EMAIL) VALUES(?,?,?);";
		return getJdbcTemplate().update(insertSql, user.getAsuserUserid(), user.getAsuserUsername(), user.getAsuserEmail());
	}
	
	public int update(User user) {
		String updateSql = "update ASUSER set ASUSER_USERNAME=?,ASUSER_EMAIL=? where ASUSER_USERID=?";
		return getJdbcTemplate().update(updateSql, user.getAsuserUsername(), user.getAsuserEmail(), user.getAsuserUserid());
	}

	@Override
	public int deleteUser(String id) {
		String deleteSql = "delete from ASUSER where ASUSER_USERID=?";
		return getJdbcTemplate().update(deleteSql, id);
	}
}