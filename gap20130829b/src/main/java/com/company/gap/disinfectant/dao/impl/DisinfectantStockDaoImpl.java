package com.company.gap.disinfectant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.disinfectant.dao.IDisinfectantStockDao;
import com.company.gap.disinfectant.model.Stock;

@Repository
public class DisinfectantStockDaoImpl extends BaseDaoImpl<Stock> implements IDisinfectantStockDao<Stock> {

	@Override
	public List<Stock> findStockList() {
		String sql = "select * from " + this.getTableName() + " where quantity>0";
		return this.findList(sql);
	}

	@Override
	public int addStockQuantity(Integer id, double quantity) {
		String sql = "update " + this.getTableName() + " set quantity=quantity+? where id=?";
		return jdbcTemplate.update(sql, quantity, id);
	}
}