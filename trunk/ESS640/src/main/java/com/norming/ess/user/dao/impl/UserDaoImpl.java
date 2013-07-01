package com.norming.ess.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.norming.ess.user.dao.IUserDao;
import com.norming.ess.user.model.User;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> selectAll(){
		String querySql = "select ASUSER_USERID, ASUSER_USERNAME, ASUSER_EMAIL from ASUSER";
		return jdbcTemplate.query(querySql, new BeanPropertyRowMapper<User>(User.class));
	}
	
	public User selectById(String id){
		String querySql = "select ASUSER_USERID,ASUSER_USERNAME,ASUSER_EMAIL from ASUSER where ASUSER_USERID = ?";
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