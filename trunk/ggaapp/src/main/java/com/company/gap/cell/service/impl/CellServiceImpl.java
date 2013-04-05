package com.company.gap.cell.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.Dto;
import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.entity.TCell;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;

@Service
public class CellServiceImpl implements ICellService {

	@Autowired
	private ICellDao cellDao;
	
	@Override
	public List<Dto> findAllCells() {
		return cellDao.findAllCells();
	}
	
	@Override
	public List<Dto> findCellsByStatus(CellStatus cellStatus) {
		return cellDao.findCellsByStatus(cellStatus.getStatus());
	}
	
	
	@Override
	public Dto findCellById(int cellId) {
		return this.cellDao.findCellById(cellId);
	}

	@Override
	public int saveCell(Dto data) {
		if (StringUtils.isEmpty(data.getString("cell_id"))) {
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
		for (Dto dto : this.findAllCells()) {
			cellId2Name.put(dto.getInt(TCell.ID), dto.getString(TCell.CODE));
		}
		return cellId2Name;
	}
	
	@Override
	public int updateStatus(int cell_id, int cell_status) {
		return cellDao.updateStatus(cell_id, cell_status);
	}
}