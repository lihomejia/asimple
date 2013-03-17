package com.company.gap.resource.dao.impl;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.resource.dao.IResourceDao;

@Repository
public class ResourceDaoImpl implements IResourceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> findResourceById(int resourceId) {
		String sql = "select resource_id, resource_name, resource_cate, resource_type from t_input_resource where resource_id=?";
		return jdbcTemplate.queryForMap(sql, resourceId);
	}

	@Override
	public int insert(Map<String, Object> data) {
		String sql = "insert into t_input_resource(resource_name,resource_cate,resource_type) values (?,?,?)";
		return jdbcTemplate.update(sql, data.get("resource_name"), data.get("resource_cate"), data.get("resource_type"));
	}

	@Override
	public int update(Map<String, Object> data) {
		String sql = "update t_input_resource set resource_name=? where resource_id=?";
		return jdbcTemplate.update(sql, data.get("resource_name"), data.get("resource_id"));
	}
	
	@Override
	public int delete(int... resourceIds) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from t_input_resource where resource_id in (?");
		for (int i = 1; i < resourceIds.length; i++) {
			sql.append(",?");
		}
		sql.append(")");
		Object[] os = new Object[resourceIds.length];
		for (int i = 0; i< resourceIds.length; i++) {
			os[i] = resourceIds[i];
		}
		return jdbcTemplate.update(sql.toString(), os);
	}
}
