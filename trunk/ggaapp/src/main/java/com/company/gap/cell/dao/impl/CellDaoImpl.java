package com.company.gap.cell.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.entity.Cell;
import com.company.gap.cell.enumeration.CellStatus;

@Repository
public class CellDaoImpl implements ICellDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Map<String, Object>> findAllProductionCell() {
		String sql = "select cell_id, cell_code, cell_location, cell_area, cell_cdate, cell_status from t_production_cell";
		return jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public List<Cell> findProductionCells(CellStatus cellStatus) {
		String sql = "select cell_id, cell_code, cell_location, cell_area, cell_cdate, cell_status from t_production_cell where cell_status=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Cell>(Cell.class), cellStatus.getStatus());
	}
	
	@Override
	public Map<String, Object> findProductionCellById(int cellId) {
		String sql = "select cell_id, cell_code, cell_location, cell_area, cell_cdate, cell_status from t_production_cell where cell_id=?";
		return jdbcTemplate.queryForMap(sql, cellId);
	}


	@Override
	public int insert(Map<String, Object> data) {
		String sql = "insert into t_production_cell(cell_code, cell_location, cell_area, cell_cdate, cell_status) values (?,?,?,?,0)";
		return jdbcTemplate.update(sql, data.get("cell_code"), data.get("cell_location"), data.get("cell_area"), data.get("cell_cdate"));
	}

	@Override
	public int update(Map<String, Object> data) {
		String sql = "update t_production_cell set cell_code=?,cell_location=?,cell_area=?,cell_cdate=? where cell_id=?";
		return jdbcTemplate.update(sql, data.get("cell_code"), data.get("cell_location"), data.get("cell_area"), data.get("cell_cdate"), data.get("cell_id"));
	}
	
	public int updateStatus(int cell_id, int cell_status) {
		String sql = "update t_production_cell set cell_status=? where cell_id=?";
		return jdbcTemplate.update(sql, cell_status, cell_id);
	}

	@Override
	public int delete(int... cellIds) {
		int len = cellIds.length;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from t_production_cell where cell_id in (?");
		Object[] pros = new Object[len];
		pros[0] = cellIds[0];
		for (int i = 1; i < len; i++) {
			pros[i] = cellIds[i];
			sql.append(",?");
		}
		sql.append(")");
		return jdbcTemplate.update(sql.toString(), pros);
	}

}
