package com.company.gap.cell.dao;

import java.util.List;

import com.company.gap.base.util.Dto;

public interface ICellDao {
	List<Dto> findAllCells();
	
	List<Dto> findCellsByStatus(int status);
	
	Dto findCellById(int cellId);
	
	int insert(Dto dto);
	
	int update(Dto dto);
	
	public int updateStatus(int cell_id, int cell_status);
	
	int delete(int... cellIds);
}