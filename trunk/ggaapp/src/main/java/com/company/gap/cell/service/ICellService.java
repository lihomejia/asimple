package com.company.gap.cell.service;

import java.util.List;
import java.util.Map;

import com.company.gap.cell.entity.Cell;
import com.company.gap.cell.enumeration.CellStatus;

public interface ICellService {
	List<Map<String, Object>> findAllProductionCell();
	
	List<Cell> findProductionCells(CellStatus cellStatus);
	
	Map<String, Object> findProductionCellById(int cellId);
	
	int saveCell(Map<String, Object> data);
	
	int delete(int... cellIds);
	
	Map<Integer, String> queryCellId2Code();
	
	public int updateStatus(int cell_id, int cell_status);
}
