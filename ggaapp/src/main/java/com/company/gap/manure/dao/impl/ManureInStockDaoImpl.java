package com.company.gap.manure.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.base.util.ColumnDtoRowMapper;
import com.company.gap.base.util.Dto;
import com.company.gap.manure.dao.IManureInStockDao;
import com.company.gap.manure.tab.TInStock;

@Repository
public class ManureInStockDaoImpl implements IManureInStockDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Dto findInStockById(int instock_id) {
		String sql = new StringBuffer()
			.append("select instock_id,")
			.append(" instock_stockid, instock_nameid, instock_sizeid, instock_batchid, instock_producerid,")
			.append(" instock_quantity, instock_location, instock_element, instock_indate, instock_kindid,")
			.append(" instock_expirydate, instock_vendor, instock_wrap, instock_inmanager, instock_comment,")
			.append(" instock_status")
			.append(" from t_manure_instock")
			.append(" where instock_id=?")
		.toString();
		List<Dto> instocks = jdbcTemplate.query(sql, new ColumnDtoRowMapper(), instock_id);
		
		return instocks.isEmpty() ? null : instocks.get(0);
	}
	
	@Override
	public int insert(Dto in) {
		String sql = new StringBuffer()
			.append("insert into t_manure_instock(")
			.append("instock_stockid, instock_nameid, instock_sizeid, instock_batchid, instock_producerid,")
			.append("instock_quantity, instock_location, instock_element, instock_indate, instock_kindid,")
			.append("instock_expirydate, instock_vendor, instock_wrap, instock_inmanager, instock_comment")
			.append(") values (")
			.append("?,?,?,?,?,")
			.append("?,?,?,?,?,")
			.append("?,?,?,?,?")
			.append(")")
		.toString();
		return jdbcTemplate.update(sql, 
				in.getInt(TInStock.STOCKID), in.getInt(TInStock.NAMEID), in.getInt(TInStock.SIZEID), in.getInt(TInStock.BATCHID), in.getInt(TInStock.PRODUCERID),
				in.getDouble(TInStock.QUANTITY), in.getString(TInStock.LOCATION), in.getString(TInStock.ELEMENT), in.getDate(TInStock.INDATE), in.getInt(TInStock.KINDID),
				in.getDate(TInStock.EXPIRYDATE), in.getString(TInStock.VENDOR), in.getString(TInStock.WRAP), in.getString(TInStock.INMANAGER), in.getString(TInStock.COMMENT)
		);
	}
	
	@Override
	public int update(Dto in) {
		String sql = new StringBuffer()
			.append("update t_manure_instock set ")
			.append(" instock_stockid=?, instock_nameid=?, instock_sizeid=?, instock_batchid=?, instock_producerid=?,")
			.append(" instock_quantity=?, instock_location=?, instock_element=?, instock_indate=?, instock_kindid=?,")
			.append(" instock_expirydate=?, instock_vendor=?, instock_wrap=?, instock_inmanager=?, instock_comment=?")
			.append(" where instock_id=?")
		.toString();
		return jdbcTemplate.update(sql, 
				in.getInt(TInStock.STOCKID), in.getInt(TInStock.NAMEID), in.getInt(TInStock.SIZEID), in.getInt(TInStock.BATCHID), in.getInt(TInStock.PRODUCERID),
				in.getDouble(TInStock.QUANTITY), in.getString(TInStock.LOCATION), in.getString(TInStock.ELEMENT), in.getDate(TInStock.INDATE), in.getInt(TInStock.KINDID),
				in.getDate(TInStock.EXPIRYDATE), in.getString(TInStock.VENDOR), in.getString(TInStock.WRAP), in.getString(TInStock.INMANAGER), in.getString(TInStock.COMMENT),
				in.getInt(TInStock.ID)
		);
	}
	
	
	@Override
	public int delete(int instock_id) {
		String sql = "delete from t_manure_instock where instock_id=?";
		return jdbcTemplate.update(sql, instock_id);
	}
	
	@Override
	public int auditing(int instock_id, int stock_id) {
		String sql = "update t_manure_instock set instock_stockid=?, instock_status=? where instock_id=?";
		return jdbcTemplate.update(sql, stock_id, 1, instock_id);
	}

	@Override
	public int nullify(int instock_id) {
		String sql = "update t_manure_instock set instock_status=? where instock_id=?";
		return jdbcTemplate.update(sql, 2, instock_id);
	}
}
