package com.company.gap.manure.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.dao.IManureResourceDao;
import com.company.gap.manure.tab.TResource;

@Repository
public class ManureResourceDaoImpl implements IManureResourceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Dto> queryByType(int resourceType) {
		String sql = "select resource_id, resource_name, resource_type from t_manure_resource where resource_type=?";
		return jdbcTemplate.query(sql, new ColumnDtoRowMapper(), resourceType);
	}
	
	@Override
	public Dto findResourceById(int resourceId) {
		String sql = "select resource_id, resource_name, resource_type from t_manure_resource where resource_id=?";
		return jdbcTemplate.queryForObject(sql, new ColumnDtoRowMapper(), resourceId);
	}
	
	@Override
	public Dto findByTypeAndName(int type, String name) {
		String sql = "select resource_id, resource_name, resource_type from t_manure_resource where resource_type=? and resource_name=?";
		List<Dto> list = jdbcTemplate.query(sql, new ColumnDtoRowMapper(), type, name);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public List<Dto> queryAll() {
		String sql = "select resource_id, resource_name, resource_type from t_manure_resource";
		return jdbcTemplate.query(sql, new ColumnDtoRowMapper());
	}

	@Override
	public int insert(Dto data) {
		String sql = "insert into t_manure_resource(resource_name,resource_type) values (?,?)";
		return jdbcTemplate.update(sql, data.getString(TResource.NAME), data.getInt(TResource.TYPE));
	}

	@Override
	public int update(Dto data) {
		String sql = "update t_manure_resource set resource_name=? where resource_id=?";
		return jdbcTemplate.update(sql, data.get("resource_name"), data.get("resource_id"));
	}
	
	@Override
	public int delete(int... resourceIds) {
		int len = resourceIds.length;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from t_manure_resource where resource_id in (?");
		Object[] pros = new Object[len];
		pros[0] = resourceIds[0];
		for (int i = 1; i < len; i++) {
			pros[i] = resourceIds[i];
			sql.append(",?");
		}
		sql.append(")");
		return jdbcTemplate.update(sql.toString(), pros);
	}
}
