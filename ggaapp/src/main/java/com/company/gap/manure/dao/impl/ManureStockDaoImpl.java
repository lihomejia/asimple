package com.company.gap.manure.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.dao.IManureStockDao;
import com.company.gap.manure.tab.TInStock;
import com.company.gap.manure.tab.TStock;

@Repository
public class ManureStockDaoImpl implements IManureStockDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Dto findStockById(int stock_id) {
		String sql = new StringBuffer()
			.append("select stock_id, stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(" from t_manure_stock")
			.append(" where stock_id=?")
		.toString();
		List<Dto> list = jdbcTemplate.query(sql, new ColumnDtoRowMapper(), stock_id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public Dto selectByStockInfo(Dto stock) {
		String sql = new StringBuffer()
			.append("select stock_id, stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(" from t_manure_stock")
			.append(" where stock_nameid=?")
			.append(" and stock_sizeid=?")
			.append(" and stock_batchid=?")
			.append(" and stock_producerid=?")
		.toString();
		
		List<Dto> stocks = jdbcTemplate.query(sql, new ColumnDtoRowMapper(),
				stock.getInt(TInStock.NAMEID), stock.getInt(TInStock.SIZEID), stock.getInt(TInStock.BATCHID), stock.getInt(TInStock.PRODUCERID));
		return stocks.isEmpty() ? null : stocks.get(0);
	}
	
	@Override
	public List<Dto> queryAllStock() {
		String sql = new StringBuffer()
			.append("select stock_id, stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(" from t_manure_stock")
			.append(" where stock_quantity > 0")
			.append(" order by stock_id")
		.toString();
		return jdbcTemplate.query(sql, new ColumnDtoRowMapper());
	}
	
	@Override
	public int insertStock(final Dto stock) {
		final String sql = new StringBuffer()
			.append("insert into t_manure_stock (")
			.append("stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(") values (?,?,?,?,?,?)")
		.toString();
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				int index = 1;
				ps.setInt(index++, 		stock.getInt(TStock.NAMEID));
				ps.setInt(index++, 		stock.getInt(TStock.SIZEID));
				ps.setInt(index++, 		stock.getInt(TStock.BATCHID));
				ps.setInt(index++, 		stock.getInt(TStock.PRODUCERID));
				ps.setDouble(index++, 	stock.getDouble(TStock.QUANTITY));
				ps.setInt(index++, 		0);
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	} 

	@Override
	public int addStockQuantity(int stock_id, double quantity) {
		String sql = "update t_manure_stock set stock_quantity=stock_quantity+? where stock_id=?";
		return jdbcTemplate.update(sql, quantity, stock_id);
	}
}
