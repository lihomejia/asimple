package com.company.gap.grow.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.grow.dao.IGrowHarvestDao;
import com.company.gap.grow.tab.THarvest;

@Repository
public class GrowHarvestDaoImpl implements IGrowHarvestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Dto findHarvestById(int harvest_id) {
		String sql = new StringBuffer()
			.append("select harvest_id,harvest_registerid,harvest_cellid,harvest_pname,harvest_batch,harvest_operatedate,harvest_method,harvest_scale,harvest_yield,harvest_storage,harvest_respmanager,harvest_storemanager,harvest_comment")
			.append(" from t_grow_harvest")
			.append(" where harvest_id=?")
		.toString();
		return jdbcTemplate.queryForObject(sql, new ColumnDtoRowMapper(), harvest_id);
	}

	@Override
	public int insert(Dto data) {
		String sql = new StringBuffer()
			.append("insert into t_grow_harvest (harvest_registerid,harvest_cellid,harvest_pname,harvest_batch,harvest_operatedate,harvest_method,harvest_scale,harvest_yield,harvest_storage,harvest_respmanager,harvest_storemanager,harvest_comment)")
			.append(" values (?,?,?,?,?,?,?,?,?,?,?,?)")
		.toString();
		return jdbcTemplate.update(sql, 
				data.getInt(THarvest.REGISTERID), data.getInt(THarvest.CELLID), data.getString(THarvest.PNAME), data.getInt(THarvest.BATCH), data.getDate(THarvest.OPERATEDATE), data.getString(THarvest.METHOD),
				data.getString(THarvest.SCALE), data.getDouble(THarvest.YIELD), data.getString(THarvest.STORAGE), data.getString(THarvest.RESPMANAGER), data.getString(THarvest.STOREMANAGER),
				data.getString(THarvest.COMMENT)
				);
	}

	@Override
	public int update(Dto data) {
		String sql = new StringBuffer()
			.append("update t_grow_harvest set harvest_pname=?,harvest_batch=?,harvest_operatedate=?,harvest_method=?,harvest_scale=?,harvest_yield=?,harvest_storage=?,harvest_respmanager=?,harvest_storemanager=?,harvest_comment=?")
			.append(" where harvest_id=?")
		.toString();
		return jdbcTemplate.update(sql, data.getString(THarvest.PNAME), data.getInt(THarvest.BATCH), data.getDate(THarvest.OPERATEDATE), data.getString(THarvest.METHOD), data.getString(THarvest.SCALE), data.getDouble(THarvest.YIELD),
				data.getString(THarvest.STORAGE), data.getString(THarvest.RESPMANAGER), data.getString(THarvest.STOREMANAGER), data.getString(THarvest.COMMENT), data.getInt(THarvest.ID));
	}
	
	@Override
	public int delete(int harvest_id) {
		String sql = "delete from t_grow_harvest where harvest_id=?";
		return jdbcTemplate.update(sql, harvest_id);
	}

}
