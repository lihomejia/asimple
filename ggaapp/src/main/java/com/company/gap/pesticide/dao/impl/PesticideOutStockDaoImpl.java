package com.company.gap.pesticide.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.pesticide.dao.IPesticideOutStockDao;
import com.company.gap.pesticide.entity.PesticideOutStock;

@Repository
public class PesticideOutStockDaoImpl implements IPesticideOutStockDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public PesticideOutStock findInStockById(int outstock_id) {
		String sql = new StringBuffer()
			.append("select outstock_id, outstock_stockid, outstock_cellid, outstock_quantity, outstock_status, outstock_outdate, outstock_outmanager, outstock_comment,")
			.append(" outstock_nameid, outstock_sizeid, outstock_batchid, outstock_producerid, outstock_kindid")
			.append(" from t_pesticide_outstock")
			.append(" where outstock_id=?")
		.toString();
		List<PesticideOutStock> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PesticideOutStock>(PesticideOutStock.class), outstock_id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int insert(PesticideOutStock out) {
		String sql = new StringBuffer()
			.append("insert into t_pesticide_outstock (")
			.append(" outstock_stockid, outstock_cellid, outstock_quantity, outstock_status, outstock_outdate,")
			.append(" outstock_nameid, outstock_sizeid, outstock_batchid, outstock_producerid, outstock_kindid,")
			.append(" outstock_outmanager, outstock_comment")
			.append(") values (?,?,?,?,?,?,?,?,?,?,?,?)")
		.toString();
		return jdbcTemplate.update(sql, 
				out.getOutstock_stockid(), out.getOutstock_cellid(), out.getOutstock_quantity(), 0, out.getOutstock_outdate(),
				out.getOutstock_nameid(), out.getOutstock_sizeid(), out.getOutstock_batchid(), out.getOutstock_producerid(), out.getOutstock_kindid(),
				out.getOutstock_outmanager(), out.getOutstock_comment());
		
	}
	
	@Override
	public int update(PesticideOutStock out) {
		String sql = new StringBuffer()
		.append("update t_pesticide_outstock set")
		.append(" outstock_stockid=?, outstock_cellid=?, outstock_quantity=?, outstock_status=?, outstock_outdate=?,")
		.append(" outstock_outmanager=?, outstock_comment=?")
		.append(" where outstock_id=?")
		.toString();
		return jdbcTemplate.update(sql, 
				out.getOutstock_stockid(), out.getOutstock_cellid(), out.getOutstock_quantity(), 0, out.getOutstock_outdate(),
				out.getOutstock_outmanager(), out.getOutstock_comment(), 
				out.getOutstock_id());
	}
	
	@Override
	public int delete(int outstock_id) {
		String sql = "delete from t_pesticide_outstock where outstock_id=?";
		return jdbcTemplate.update(sql, outstock_id);
	}
	
	@Override
	public int auditing(int outstock_id) {
		String sql = "update t_pesticide_outstock set outstock_status=? where outstock_id=?";
		return jdbcTemplate.update(sql, 1, outstock_id);
	}

	@Override
	public int nullify(int outstock_id) {
		String sql = "update t_pesticide_outstock set outstock_status=? where outstock_id=?";
		return jdbcTemplate.update(sql, 2, outstock_id);
	}

}
