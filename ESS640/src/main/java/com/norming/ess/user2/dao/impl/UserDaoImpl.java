package com.norming.ess.user2.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.norming.ess.user2.dao.IUserDao;
import com.norming.ess.user2.model.User;

public class UserDaoImpl implements IUserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<User> selectAll(){
		String querySql = "select ASUSER_USERID, ASUSER_USERNAME, ASUSER_EMAIL, ASUSER_PWD from ASUSER";
		return jdbcTemplate.query(querySql, new BeanPropertyRowMapper<User>(User.class));
	}
	
	public User selectById(String id){
		String querySql = "select ASUSER_USERID,ASUSER_USERNAME,ASUSER_EMAIL, ASUSER_PWD from ASUSER where ASUSER_USERID = ?";
		return jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class),id);
	}
	
	public int insert(User user){
		String insertSql = "INSERT INTO ASUSER (ASUSER_USERID,ASUSER_USERNAME,ASUSER_EMAIL) VALUES(?,?,?);";
		return jdbcTemplate.update(insertSql, user.getAsuserUserid(), user.getAsuserUsername(), user.getAsuserEmail());
	}
	
	public int update(User user){
		String updateSql = "update ASUSER set ASUSER_USERNAME=?,ASUSER_EMAIL=? where ASUSER_USERID=?";
		return jdbcTemplate.update(updateSql, user.getAsuserUsername(), user.getAsuserEmail(), user.getAsuserUserid());
	}

	@Override
	public int deleteUser(String id) {
		String deleteSql = "delete from ASUSER where ASUSER_USERID=?";
		return jdbcTemplate.update(deleteSql, id);
	}
}