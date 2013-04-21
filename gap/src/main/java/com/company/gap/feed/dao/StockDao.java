package com.company.gap.feed.dao;

import java.util.List;
import java.util.Map;

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
	public Stock selectById(String stockId){
		String sql = "SELECT id,rsid,spid,batchid,producerid,typeid,total_quantity as totalQuantity,updatetime FROM t_stock where id = ?";
		List<Stock> stock = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Stock>(Stock.class), stockId);
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
		String sql = "insert into t_stock (id,rsid,spid,batchid,producerid,typeid,total_quantity,updatetime) values (?,?,?,?,?,?,?,curdate())";
		return jdbcTemplate.update(sql,stock.getId(),stock.getRsid(),stock.getSpid(),stock.getBatchid(),
				stock.getProducerid(),stock.getTypeid(),stock.getTotalQuantity());
	}
	
	/**
	 * 查询一种饲料的库存，若没有返回空。
	 * @param godownEntry 入库单
	 */
	public Stock selectOnlyStock(String rsid, String spid, String batchid,
			String producerid, String typeid) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT id,rsid,spid,batchid,producerid,typeid,total_quantity as totalQuantity,updatetime ");
		sql.append("FROM t_stock where rsid = ? and spid = ? and batchid = ? and producerid = ? and typeid = ?");
		List<Stock> stocks = jdbcTemplate.query(sql.toString(),
				new BeanPropertyRowMapper<Stock>(Stock.class), rsid, spid,
				batchid, producerid, typeid);
		return stocks.isEmpty() ? null : stocks.get(0);
	}
	
	/**
	 * 查询所有库存
	 */
	public List<Map<String,Object>> selecAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT stock.*,tfr_rs.name rsname,tfr_sp.name spname,tfr_batch.name batchname,tfr_producer.name producername,tfr_type.name typename ");
		sql.append("FROM t_stock stock ");
		sql.append("LEFT JOIN t_feed_resource tfr_rs ON stock.rsid = tfr_rs.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_sp ON stock.spid = tfr_sp.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_batch ON stock.batchid = tfr_batch.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_producer ON stock.producerid = tfr_producer.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_type ON stock.typeid = tfr_type.id ");
		sql.append("order by tfr_rs.name");
		return jdbcTemplate.queryForList(sql.toString());
	}
	
	/**
	 * 删除库存
	 * @param id 库存ID
	 */
	public int deleteById(String id) {
		String sql = "delete from t_stock where id = ?";
		return jdbcTemplate.update(sql, id);
	}
	
	/**
	 * 减除库存
	 * @param id 库存ID
	 * @param quantity 要减除的库存数量
	 */
	public int subQuantity(String id, int quantity) {
		String sql = "update t_stock set total_quantity = total_quantity - ? where id = ?";
		return jdbcTemplate.update(sql, quantity, id);
	}
}
