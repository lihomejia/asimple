package com.company.gap.cell.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.util.Dto;
import com.company.gap.cell.enumeration.CellStatus;

public interface ICellService {
	
	List<Dto> findAllCells();
	
	List<Dto> findCellsByStatus(CellStatus cellStatus);
	
	Dto findCellById(int cellId);
	
	int saveCell(Dto data);
	
	int delete(int... cellIds);
	
	Map<Integer, String> queryCellId2Code();
	
	int updateStatus(int cell_id, int cell_status);
}
