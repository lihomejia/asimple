package com.company.gap.grow.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.dao.IGrowFarmDao;
import com.company.gap.grow.tab.TFarm;

@Repository
public class GrowFarmDaoImpl implements IGrowFarmDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Dto findFarmById(int farm_id) {
		String sql = new StringBuffer()
			.append("select farm_id,farm_registerid,farm_cellid,farm_date,farm_content,farm_scope,farm_people,farm_manager,farm_comment")
			.append(" from t_grow_farm")
			.append(" where farm_id=?")
		.toString();
		return jdbcTemplate.queryForObject(sql, new ColumnDtoRowMapper(), farm_id);
	}

	@Override
	public int insert(Dto data) {
		String sql = new StringBuffer()
			.append("insert into t_grow_farm (farm_registerid,farm_cellid,farm_date,farm_content,farm_scope,farm_people,farm_manager,farm_comment)")
			.append(" values (?,?,?,?,?,?,?,?)")
		.toString();
		return jdbcTemplate.update(sql, 
				data.getInt(TFarm.REGISTERID), data.getInt(TFarm.CELLID), data.getDate(TFarm.DATE), data.getString(TFarm.CONTENT),
				data.getDouble(TFarm.SCOPE), data.getInt(TFarm.PEOPLE), data.getString(TFarm.MANAGER), data.getString(TFarm.COMMENT));
	}

	@Override
	public int update(Dto data) {
		String sql = new StringBuffer()
			.append("update t_grow_farm set farm_date=?,farm_content=?,farm_scope=?,farm_people=?,farm_manager=?,farm_comment=?")
			.append(" where farm_id=?")
		.toString();
		return jdbcTemplate.update(sql, data.getDate(TFarm.DATE), data.getString(TFarm.CONTENT), data.getDouble(TFarm.SCOPE), data.getInt(TFarm.PEOPLE),
				data.getString(TFarm.MANAGER), data.getString(TFarm.COMMENT), data.getInt(TFarm.ID));
	}
	
	@Override
	public int delete(int farm_id) {
		String sql = "delete from t_grow_farm where farm_id=?";
		return jdbcTemplate.update(sql, farm_id);
	}

}
