package com.company.gap.cell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.cell.dao.ICellDao;
import com.company.gap.cell.model.Cell;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private ICellDao<Cell> cellDao;
	
	@RequestMapping("test1")
	public void test1() {
		Cell cell = new Cell();
		System.out.println(cellDao.findList(cell));
	}
}
