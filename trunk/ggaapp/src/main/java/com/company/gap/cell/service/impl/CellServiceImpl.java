package com.company.gap.cell.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.model.Cell;
import com.company.gap.cell.service.ICellService;

@Service
public class CellServiceImpl implements ICellService {

	@Autowired
	private ICellDao<Cell> cellDao;
	
	@Override
	public List<Cell> findAll() {
		return cellDao.findList();
	}
	
	@Override
	public List<Cell> findByStatus(CellStatus cellStatus) {
		Cell cell = new Cell();
		cell.setUsestatus(cellStatus.getStatus());
		return cellDao.findList(cell);
	}
	
	
	@Override
	public Cell findById(Integer id) {
		return this.cellDao.findById(id);
	}

	@Override
	public int save(Cell cell) {
		if (cell.getId() == null) {
			return cellDao.insert(cell);
		}
		else {
			return cellDao.update(cell);
		}
	}

	@Override
	public int deleteById(Integer id) {
		return cellDao.deleteById(id);
	}
	
	@Override
	public Map<Integer, String> queryId2Code() {
		Map<Integer, String> cellId2Name = new HashMap<Integer, String>();
		for (Cell cell : this.findAll()) {
			cellId2Name.put(cell.getId(), cell.getCode());
		}
		return cellId2Name;
	}
	
	@Override
	public int updateStatus(Integer id, Integer status) {
		Cell cell = new Cell();
		cell.setId(id);
		cell.setUsestatus(status);
		return cellDao.update(cell);
	}
}