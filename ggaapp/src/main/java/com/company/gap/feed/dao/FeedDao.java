package com.company.gap.feed.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.feed.entity.GodownEntry;

@Repository
public class FeedDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(GodownEntry godownEntry) {
		String sql = "insert into t_godown_entry(id,rsid,spid,batchid,producerid,typeid,quantity,"
				+ "origin,ingredient,createdate,expdate,suppliers,packing,operator,status,remark) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, godownEntry.getId(), godownEntry
				.getSpid(), godownEntry.getSpid(), godownEntry.getBatchid(),
				godownEntry.getProducerid(), godownEntry.getTypeid(),
				godownEntry.getQuantity(), godownEntry.getOrigin(), godownEntry
						.getIngredient(), godownEntry.getCreateDate(),
				godownEntry.getExpdate(), godownEntry.getSuppliers(),
				godownEntry.getPacking(), godownEntry.getOperator(),
				godownEntry.getStatus(), godownEntry.getRemark());
	}

}
