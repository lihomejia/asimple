package com.company.gap.grow.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.grow.dao.IGrowRegisterDao;
import com.company.gap.grow.entity.GrowRegister;
import com.company.gap.grow.enumeration.GrowStatus;

@Repository
public class GrowRegiesterDaoImpl implements IGrowRegisterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public GrowRegister findGrowRegister(int registerId) {
		String sql = "select register_id, register_cellid, register_person, register_regdate, register_desc, register_status, register_comment from t_grow_register where register_id=?";
		List<GrowRegister> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<GrowRegister>(GrowRegister.class), registerId);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public int insert(GrowRegister register) {
		String sql = "insert into t_grow_register(register_cellid, register_person, register_regdate, register_desc, register_status, register_comment) values(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, register.getRegister_cellid(), register.getRegister_person(), register.getRegister_regdate(), register.getRegister_desc(), register.getRegister_status(), register.getRegister_comment());
	}

	@Override
	public int update(GrowRegister register) {
		String sql = "update t_grow_register set register_cellid=?, register_person=?, register_regdate=?, register_desc=?, register_status=?, register_comment=? where register_id=?";
		return jdbcTemplate.update(sql, register.getRegister_cellid(), register.getRegister_person(), register.getRegister_regdate(), register.getRegister_desc(), register.getRegister_status(), register.getRegister_comment(), register.getRegister_id());
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
	public List<Map<String, Object>> findGrowingInfos() {
		String sql = new StringBuffer()
			.append("select register_id, cell_id, cell_code, cell_location ")
			.append(" from t_grow_register, t_production_cell")
			.append(" where register_cellid = cell_id")
			.append(" and register_status = ").append(GrowStatus.GOING.getStatus())
			.append(" and cell_status = ").append(CellStatus.OCCUPY.getStatus())
			.toString()
		;
		return jdbcTemplate.queryForList(sql);
	}
}
