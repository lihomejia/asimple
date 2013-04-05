package com.company.gap.cell.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.entity.TCell;

@Repository
public class CellDaoImpl implements ICellDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Dto> findAllCells() {
		String sql = "select cell_id, cell_code, cell_location, cell_area, cell_cdate, cell_status from t_production_cell";
		return jdbcTemplate.query(sql, new ColumnDtoRowMapper());
	}
	
	@Override
	public List<Dto> findCellsByStatus(int status) {
		String sql = "select cell_id, cell_code, cell_location, cell_area, cell_cdate, cell_status from t_production_cell where cell_status=?";
		return jdbcTemplate.query(sql, new ColumnDtoRowMapper(), status);
	}
	
	@Override
	public Dto findCellById(int cellId) {
		String sql = "select cell_id, cell_code, cell_location, cell_area, cell_cdate, cell_status from t_production_cell where cell_id=?";
		return jdbcTemplate.queryForObject(sql, new ColumnDtoRowMapper(), cellId);
	}


	@Override
	public int insert(Dto dto) {
		String sql = "insert into t_production_cell(cell_code, cell_location, cell_area, cell_cdate, cell_status) values (?,?,?,?,0)";
		return jdbcTemplate.update(sql, dto.getString(TCell.CODE), dto.getString(TCell.LOCATION), dto.getDouble(TCell.AREA), dto.getDate(TCell.CDATE));
	}

	@Override
	public int update(Dto dto) {
		String sql = "update t_production_cell set cell_code=?,cell_location=?,cell_area=?,cell_cdate=? where cell_id=?";
		return jdbcTemplate.update(sql, dto.getString(TCell.CODE), dto.getString(TCell.LOCATION), dto.getDouble(TCell.AREA), dto.getDate(TCell.CDATE), dto.getInt(TCell.ID));
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
