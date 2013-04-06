package com.company.gap.grow.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.dao.IGrowIrrigateDao;
import com.company.gap.grow.tab.TIrrigate;

@Repository
public class GrowIrrigateDaoImpl implements IGrowIrrigateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Dto findIrrigateById(int irrigate_id) {
		String sql = new StringBuffer()
			.append("select irrigate_id,irrigate_registerid,irrigate_cellid,irrigate_date,irrigate_way,irrigate_area,irrigate_quantum,irrigate_manager,irrigate_approver,irrigate_comment")
			.append(" from t_grow_irrigate")
			.append(" where irrigate_id=?")
		.toString();
		return jdbcTemplate.queryForObject(sql, new ColumnDtoRowMapper(), irrigate_id);
	}

	@Override
	public int insert(Dto data) {
		String sql = new StringBuffer()
			.append("insert into t_grow_irrigate (irrigate_registerid,irrigate_cellid,irrigate_date,irrigate_way,irrigate_area,irrigate_quantum,irrigate_manager,irrigate_approver,irrigate_comment)")
			.append(" values (?,?,?,?,?,?,?,?,?)")
		.toString();
		return jdbcTemplate.update(sql, 
				data.getInt(TIrrigate.REGISTERID), data.getInt(TIrrigate.CELLID), data.getDate(TIrrigate.DATE), data.getString(TIrrigate.WAY),
				data.getDouble(TIrrigate.AREA), data.getDouble(TIrrigate.QUANTUM), data.getString(TIrrigate.MANAGER), data.getString(TIrrigate.APPROVER), data.getString(TIrrigate.COMMENT));
	}

	@Override
	public int update(Dto data) {
		String sql = new StringBuffer()
			.append("update t_grow_irrigate set irrigate_date=?,irrigate_way=?,irrigate_area=?,irrigate_quantum=?,irrigate_manager=?,irrigate_approver=?,irrigate_comment=?")
			.append(" where irrigate_id=?")
		.toString();
		return jdbcTemplate.update(sql, data.getDate(TIrrigate.DATE), data.getString(TIrrigate.WAY), data.getDouble(TIrrigate.AREA), data.getDouble(TIrrigate.QUANTUM),
				data.getString(TIrrigate.MANAGER), data.getString(TIrrigate.APPROVER), data.getString(TIrrigate.COMMENT), data.getInt(TIrrigate.ID));
	}
	
	@Override
	public int delete(int irrigate_id) {
		String sql = "delete from t_grow_irrigate where irrigate_id=?";
		return jdbcTemplate.update(sql, irrigate_id);
	}

}
