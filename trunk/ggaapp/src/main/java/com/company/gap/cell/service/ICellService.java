package com.company.gap.cell.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.service.IBaseService;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.model.Cell;

public interface ICellService extends IBaseService<Cell> {
	
	List<Cell> findByStatus(CellStatus cellStatus);
	
	Map<Integer, String> queryId2Code();
	
	int updateStatus(Integer id, Integer status);
}