package com.company.gap.cell.service;

import java.util.Map;

public interface ICellService {
	public Map<String, Object> findProductionCellById(int cellId);
	
	public int saveCell(Map<String, Object> data);
	
	public int delete(int... cellIds);
}
