package com.company.gap.cell.dao;

import java.util.List;
import java.util.Map;

import com.company.gap.cell.entity.Cell;
import com.company.gap.cell.enumeration.CellStatus;

public interface ICellDao {
	List<Map<String, Object>> findAllProductionCell();
	
	List<Cell> findProductionCells(CellStatus cellStatus);
	
	Map<String, Object> findProductionCellById(int cellId);
	
	int insert(Map<String, Object> data);
	
	int update(Map<String, Object> data);
	
	public int updateStatus(int cell_id, int cell_status);
	
	int delete(int... cellIds);
}
