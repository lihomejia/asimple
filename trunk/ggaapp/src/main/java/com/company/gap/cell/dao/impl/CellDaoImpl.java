package com.company.gap.cell.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.cell.dao.ICellDao;

@Repository
public class CellDaoImpl implements ICellDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> findProductionCellById(int cellId) {
		String sql = "select cell_id, cell_code, cell_location, cell_area, cell_cdate from t_production_cell where cell_id=?";
		return jdbcTemplate.queryForMap(sql, cellId);
	}


	@Override
	public int insert(Map<String, Object> data) {
		String sql = "insert into t_production_cell(cell_code, cell_location, cell_area, cell_cdate) values (?,?,?,?)";
		return jdbcTemplate.update(sql, data.get("cell_code"), data.get("cell_location"), data.get("cell_area"), data.get("cell_cdate"));
	}

	@Override
	public int update(Map<String, Object> data) {
		String sql = "update t_production_cell set cell_code=?,cell_location=?,cell_area=?,cell_cdate=? where cell_id=?";
		return jdbcTemplate.update(sql, data.get("cell_code"), data.get("cell_location"), data.get("cell_area"), data.get("cell_cdate"), data.get("cell_id"));
	}
	

	@Override
	public int delete(int... cellIds) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from t_production_cell where cell_id in (?");
		for (int i = 1; i < cellIds.length; i++) {
			sql.append(",?");
		}
		sql.append(")");
		return jdbcTemplate.update(sql.toString(), cellIds);
	}

}
