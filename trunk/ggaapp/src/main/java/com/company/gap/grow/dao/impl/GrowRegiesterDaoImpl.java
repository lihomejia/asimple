package com.company.gap.grow.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.grow.dao.IGrowRegisterDao;
import com.company.gap.grow.enumeration.GrowStatus;
import com.company.gap.grow.tab.TRegister;

@Repository
public class GrowRegiesterDaoImpl implements IGrowRegisterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Dto findGrowRegister(int registerId) {
		String sql = "select register_id, register_cellid, register_person, register_regdate, register_desc, register_status, register_comment from t_grow_register where register_id=?";
		List<Dto> list = jdbcTemplate.query(sql, new ColumnDtoRowMapper(), registerId);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public int insert(Dto register) {
		String sql = "insert into t_grow_register(register_cellid, register_person, register_regdate, register_desc, register_status, register_comment) values(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, register.getInt(TRegister.CELLID), register.getString(TRegister.PERSON), register.getDate(TRegister.REGDATE), register.getString(TRegister.DESC), register.getInt(TRegister.STATUS), register.getString(TRegister.COMMENT));
	}

	@Override
	public int update(Dto register) {
		String sql = "update t_grow_register set register_cellid=?, register_person=?, register_regdate=?, register_desc=?, register_status=?, register_comment=? where register_id=?";
		return jdbcTemplate.update(sql, register.getInt(TRegister.CELLID), register.getString(TRegister.PERSON), register.getDate(TRegister.REGDATE), register.getString(TRegister.DESC), register.getInt(TRegister.STATUS), register.getString(TRegister.COMMENT), register.getInt(TRegister.ID));
	}


	@Override
	public int auditing(int registerId) {
		String sql = "update t_grow_register set register_status=? where register_id=?";
		return jdbcTemplate.update(sql, GrowStatus.GOING.getStatus(), registerId);
	}

	@Override
	public int complete(int registerId) {
		String sql = "update t_grow_register set register_status=? where register_id=?";
		return jdbcTemplate.update(sql, GrowStatus.COMPLETED.getStatus(), registerId);
	}
	
	@Override
	public int archive(int registerId) {
		String sql = "update t_grow_register set register_status=? where register_id=?";
		return jdbcTemplate.update(sql, GrowStatus.ARCHIVED.getStatus(), registerId);
	}

	@Override
	public int delete(int registerId) {
		String sql = "delete from t_grow_register where register_id=?";
		return jdbcTemplate.update(sql, registerId);
	}

	@Override
	public List<Dto> findGrowingInfos() {
		String sql = new StringBuffer()
			.append("select register_id, cell_id, cell_code, cell_location ")
			.append(" from t_grow_register, t_production_cell")
			.append(" where register_cellid = cell_id")
			.append(" and register_status = ").append(GrowStatus.GOING.getStatus())
			.append(" and cell_status = ").append(CellStatus.OCCUPY.getStatus())
			.toString()
		;
		return jdbcTemplate.query(sql, new ColumnDtoRowMapper());
	}
}
