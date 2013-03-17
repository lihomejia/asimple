package com.company.gap.cell.service.impl;

import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.service.ICellService;

@Service
public class CellServiceImpl implements ICellService {

	@Autowired
	private ICellDao cellDao;
	
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
	
	

}
