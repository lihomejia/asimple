package com.company.gap.pesticide.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.company.gap.pesticide.dao.IPesticideStockDao;
import com.company.gap.pesticide.entity.PesticideStock;

@Repository
public class PesticideStockDaoImpl implements IPesticideStockDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public PesticideStock findStockById(int stock_id) {
		String sql = new StringBuffer()
			.append("select stock_id, stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(" from t_pesticide_stock")
			.append(" where stock_id=?")
		.toString();
		List<PesticideStock> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PesticideStock>(PesticideStock.class), stock_id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public PesticideStock selectByStockInfo(PesticideStock stock) {
		String sql = new StringBuffer()
			.append("select stock_id, stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(" from t_pesticide_stock")
			.append(" where stock_nameid=?")
			.append(" and stock_sizeid=?")
			.append(" and stock_batchid=?")
			.append(" and stock_producerid=?")
		.toString();
		
		List<PesticideStock> stocks = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PesticideStock>(PesticideStock.class),
				stock.getStock_nameid(), stock.getStock_sizeid(), stock.getStock_batchid(), stock.getStock_producerid());
		return stocks.isEmpty() ? null : stocks.get(0);
	}
	
	@Override
	public List<Map<String, Object>> queryAllStock() {
		String sql = new StringBuffer()
			.append("select stock_id, stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(" from t_pesticide_stock")
			.append(" where stock_quantity > 0")
			.append(" order by stock_id")
		.toString();
		return jdbcTemplate.queryForList(sql);
	}
	
	@Override
	public int insertStock(final PesticideStock stock) {
		final String sql = new StringBuffer()
			.append("insert into t_pesticide_stock (")
			.append("stock_nameid, stock_sizeid, stock_batchid, stock_producerid, stock_quantity, stock_status")
			.append(") values (?,?,?,?,?,?)")
		.toString();
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				int index = 1;
				ps.setInt(index++, 		stock.getStock_nameid());
				ps.setInt(index++, 		stock.getStock_sizeid());
				ps.setInt(index++, 		stock.getStock_batchid());
				ps.setInt(index++, 		stock.getStock_producerid());
				ps.setDouble(index++, 	stock.getStock_quantity());
				ps.setInt(index++, 		0);
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	} 

	@Override
	public int addStockQuantity(int stock_id, double quantity) {
		String sql = "update t_pesticide_stock set stock_quantity=stock_quantity+? where stock_id=?";
		return jdbcTemplate.update(sql, quantity, stock_id);
	}
}
