package com.company.gap.manure.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.manure.dao.IManureResourceDao;
import com.company.gap.manure.entity.ManureResource;

@Repository
public class ManureResourceDaoImpl implements IManureResourceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ManureResource> queryByType(int resourceType) {
		String sql = "select resource_id, resource_name, resource_type from t_manure_resource where resource_type=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ManureResource>(ManureResource.class), resourceType);
	}
	
	@Override
	public Map<String, Object> findResourceById(int resourceId) {
		String sql = "select resource_id, resource_name, resource_type from t_manure_resource where resource_id=?";
		return jdbcTemplate.queryForMap(sql, resourceId);
	}
	
	@Override
	public List<ManureResource> queryAll() {
		String sql = "select resource_id, resource_name, resource_type from t_manure_resource";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ManureResource>(ManureResource.class));
	}

	@Override
	public int insert(Map<String, Object> data) {
		String sql = "insert into t_manure_resource(resource_name,resource_type) values (?,?)";
		return jdbcTemplate.update(sql, data.get("resource_name"), data.get("resource_type"));
	}

	@Override
	public int update(Map<String, Object> data) {
		String sql = "update t_manure_resource set resource_name=? where resource_id=?";
		return jdbcTemplate.update(sql, data.get("resource_name"), data.get("resource_id"));
	}
	
	@Override
	public int delete(int... resourceIds) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from t_manure_resource where resource_id in (?");
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
