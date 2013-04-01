package com.company.gap.cell.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.entity.Cell;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;

@Service
public class CellServiceImpl implements ICellService {

	@Autowired
	private ICellDao cellDao;
	
	@Override
	public List<Map<String, Object>> findAllProductionCell() {
		return cellDao.findAllProductionCell();
	}
	
	@Override
	public List<Cell> findProductionCells(CellStatus cellStatus) {
		return cellDao.findProductionCells(cellStatus);
	}
	
	
	@Override
	public Map<String, Object> findProductionCellById(int cellId) {
		return this.cellDao.findProductionCellById(cellId);
	}

	@Override
	public int saveCell(Map<String, Object> data) {
		data.put("cell_cdate", DateUtils.parse(data.get("cell_cdate")));
		if (StringUtils.isEmpty(ObjectUtils.toString(data.get("cell_id")))) {
			return cellDao.insert(data);
		} 
		else {
			return cellDao.update(data);
		}
	}

	@Override
	public int delete(int... cellIds) {
		return cellDao.delete(cellIds);
	}
	
	@Override
	public Map<Integer, String> queryCellId2Code() {
		Map<Integer, String> cellId2Name = new HashMap<Integer, String>();
		for (Map<String, Object> mCell : this.findAllProductionCell()) {
			int cellId = NumberUtils.toInt(ObjectUtils.toString(mCell.get("cell_id")));
			String cellCode = ObjectUtils.toString(mCell.get("cell_code"));
			cellId2Name.put(cellId, cellCode);
		}
		return cellId2Name;
	}
	
	@Override
	public int updateStatus(int cell_id, int cell_status) {
		return cellDao.updateStatus(cell_id, cell_status);
	}
}