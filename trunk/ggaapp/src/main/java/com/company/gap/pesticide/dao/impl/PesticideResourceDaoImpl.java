package com.company.gap.pesticide.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.pesticide.dao.IPesticideResourceDao;
import com.company.gap.pesticide.entity.PesticideResource;

@Repository
public class PesticideResourceDaoImpl implements IPesticideResourceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PesticideResource> queryByType(int resourceType) {
		String sql = "select resource_id, resource_name, resource_type from t_pesticide_resource where resource_type=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PesticideResource>(PesticideResource.class), resourceType);
	}
	
	@Override
	public Map<String, Object> findResourceById(int resourceId) {
		String sql = "select resource_id, resource_name, resource_type from t_pesticide_resource where resource_id=?";
		return jdbcTemplate.queryForMap(sql, resourceId);
	}
	
	@Override
	public Map<String, Object> findByTypeAndName(int type, String name) {
		String sql = "select resource_id, resource_name, resource_type from t_pesticide_resource where resource_type=? and resource_name=?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, type, name);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public List<PesticideResource> queryAll() {
		String sql = "select resource_id, resource_name, resource_type from t_pesticide_resource";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PesticideResource>(PesticideResource.class));
	}

	@Override
	public int insert(Map<String, Object> data) {
		String sql = "insert into t_pesticide_resource(resource_name,resource_type) values (?,?)";
		return jdbcTemplate.update(sql, data.get("resource_name"), data.get("resource_type"));
	}

	@Override
	public int update(Map<String, Object> data) {
		String sql = "update t_pesticide_resource set resource_name=? where resource_id=?";
		return jdbcTemplate.update(sql, data.get("resource_name"), data.get("resource_id"));
	}
	
	@Override
	public int delete(int... resourceIds) {
		int len = resourceIds.length;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from t_pesticide_resource where resource_id in (?");
		Object[] pros = new Object[len];
		pros[0] = resourceIds[0];
		for (int i = 1; i < resourceIds.length; i++) {
			pros[i] = resourceIds[i];
			sql.append(",?");
		}
		sql.append(")");
		return jdbcTemplate.update(sql.toString(), pros);
	}
}
