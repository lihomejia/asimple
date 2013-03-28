package com.company.gap.cell.service;

import java.util.List;
import java.util.Map;

public interface ICellService {
	List<Map<String, Object>> findAllProductionCell();
	
	Map<String, Object> findProductionCellById(int cellId);
	
	int saveCell(Map<String, Object> data);
	
	int delete(int... cellIds);
	
	Map<Integer, String> queryCellId2Code();
}
