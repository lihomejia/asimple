package com.company.gap.cell.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.entity.Cell;

@Repository
public class CellDaoImpl extends BaseDaoImpl<Cell> implements ICellDao<Cell> {
	public CellDaoImpl() {
		super(Cell.class);
	}
}