package com.company.gap.cell.service;

import java.util.List;
import java.util.Map;

import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.model.Cell;

public interface ICellService {
	
	List<Cell> findAll();
	
	List<Cell> findByStatus(CellStatus cellStatus);
	
	Cell findById(Integer cellId);
	
	int save(Cell cell);
	
	int deleteById(Integer id);
	
	Map<Integer, String> queryId2Code();
	
	int updateStatus(Integer id, Integer status);
}