package com.company.gap.cell.dao;

import java.util.Map;

public interface ICellDao {
	Map<String, Object> findProductionCellById(int cellId);
	
	int insert(Map<String, Object> data);
	
	int update(Map<String, Object> data);
	
	int delete(int... cellIds);
}
