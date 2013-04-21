package com.company.gap.feed.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.feed.entity.FeedResource;

@Repository
public class FeedResourceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<FeedResource> selectByType(int type) {
		String sql = "select ID,NAME,TYPE from T_FEED_RESOURCE where TYPE = ?";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<FeedResource>(FeedResource.class), type);
	}

	public int insert(FeedResource resource) {
		String sql = "insert into T_FEED_RESOURCE(ID,NAME,TYPE) values (?,?,?)";
		return jdbcTemplate.update(sql,resource.getId(),resource.getName(),resource.getType());
	}

	public FeedResource selectById(String rid) {
		String sql = "select ID,NAME,TYPE from T_FEED_RESOURCE where ID = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<FeedResource>(FeedResource.class), rid);
	}

	public int update(String rid, String resourceName) {
		String sql = "update T_FEED_RESOURCE set NAME = ? where ID = ?";
		return jdbcTemplate.update(sql, resourceName, rid);
	}
	
	public int delete(String rid){
		String sql = "delete from T_FEED_RESOURCE where ID = ?";
		return jdbcTemplate.update(sql,rid);
	}
}
