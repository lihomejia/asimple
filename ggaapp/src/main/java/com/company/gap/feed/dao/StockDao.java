package com.company.gap.feed.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.feed.entity.Stock;

@Repository
public class StockDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据饲料ID，查询该饲料的库存。
	 * @param fid 饲料ID
	 * @return 饲料库存对象
	 */
	public Stock findByFid(String fid){
		String sql = "select id,feedid,total_quantity as totalQuantity,status from t_stock where feedid = ?";
		List<Stock> stock = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Stock>(Stock.class), fid);
		return stock.isEmpty() ? null : stock.get(0);
	}
	/**
	 * 增加库存
	 */
	public int addQuantity(int quantity, String stockId){
		String sql = "update t_stock set total_quantity = total_quantity + ? where id = ?";
		return jdbcTemplate.update(sql, quantity, stockId);
	}
	
	/**
	 * 添加库存
	 */
	public int insert(Stock stock) {
		String sql = "insert into t_stock (id,feedid,total_quantity,status) values (?,?,?,?)";
		return jdbcTemplate.update(sql,stock.getId(),stock.getFeedid(),stock.getTotalQuantity(),stock.getStatus());
	}
	
}
