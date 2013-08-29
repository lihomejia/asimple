package com.company.gap.pesticide.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.pesticide.dao.IPesticideStockDao;
import com.company.gap.pesticide.model.Stock;

@Repository
public class PesticideStockDaoImpl extends BaseDaoImpl<Stock> implements IPesticideStockDao<Stock> {

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