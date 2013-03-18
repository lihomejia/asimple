package com.company.gap.feed.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.gap.feed.entity.DeliveryOrder;
import com.company.gap.feed.entity.GodownEntry;

@Repository
public class FeedDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertGodownEntry(GodownEntry godownEntry) {
		String sql = "insert into t_godown_entry(id,rsid,spid,batchid,producerid,typeid,quantity,"
				+ "origin,ingredient,createdate,expdate,suppliers,packing,operator,status,remark) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, godownEntry.getId(), godownEntry
				.getRsid(), godownEntry.getSpid(), godownEntry.getBatchid(),
				godownEntry.getProducerid(), godownEntry.getTypeid(),
				godownEntry.getQuantity(), godownEntry.getOrigin(), godownEntry
						.getIngredient(), godownEntry.getCreateDate(),
				godownEntry.getExpdate(), godownEntry.getSuppliers(),
				godownEntry.getPacking(), godownEntry.getOperator(),
				godownEntry.getStatus(), godownEntry.getRemark());
	}

	public List<Map<String, Object>> selectGodownEntryList() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT	tge.*,tfr_rs.name rsname,tfr_sp.name spname,tfr_batch.name batchname,tfr_producer.name producername,tfr_type.name typename ");
		sql.append("FROM t_godown_entry tge ");
		sql.append("LEFT JOIN t_feed_resource tfr_rs ON tge.rsid = tfr_rs.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_sp ON tge.spid = tfr_sp.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_batch ON tge.batchid = tfr_batch.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_producer ON tge.producerid = tfr_producer.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_type ON tge.typeid = tfr_type.id ");
		sql.append("order by tge.createdate DESC");
		return jdbcTemplate.queryForList(sql.toString());
	}
	
	public int updateGdeStatusToPassed(String gdeid){
		String sql = "update t_godown_entry set status = 2 where id = ?";
		return jdbcTemplate.update(sql, gdeid);
	}
	
	public GodownEntry selectGodownEntryById(String id){
		String sql = "select * from t_godown_entry where id = ?";
		List<GodownEntry> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<GodownEntry>(GodownEntry.class),id);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public int deleteGde(String gdeid) {
		String sql = "DELETE FROM t_godown_entry WHERE id = ?";
		return jdbcTemplate.update(sql, gdeid);
	}
	
	public int insertDeliveryOrder(DeliveryOrder order) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_delivery_order ");
		sql.append("(id, rsid, spid, batchid, producerid, typeid, use_object, delivery_date, quantity, operator, status, remark) ");
		sql.append("values (?,?,?,?,?,?,?,?,?,?,?,?)");
		return jdbcTemplate.update(sql.toString(), order.getId(), order.getRsid(),order.getSpid(),order.getBatchid(),order.getProducerid(),
				order.getTypeid(),order.getUseObject(), order.getDeliveryDate(), order.getQuantity(),order.getOperator(), 
				order.getStatus(), order.getRemark());
	}
	
	public List<Map<String, Object>> selectDeliverOrderList() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT tdo.id, tdo.rsid, tdo.spid, tdo.batchid, tdo.producerid, tdo.typeid, tdo.use_object useObject, tdo.delivery_date deliveryDate, ");
		sql.append("tdo.quantity, tdo.operator, tdo.status, tdo.remark, ");
		sql.append("tfr_rs.name rsname,tfr_sp.name spname,tfr_batch.name batchname,tfr_producer.name producername,tfr_type.name typename ");
		sql.append("FROM t_delivery_order tdo ");
		sql.append("LEFT JOIN t_feed_resource tfr_rs ON tdo.rsid = tfr_rs.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_sp ON tdo.spid = tfr_sp.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_batch ON tdo.batchid = tfr_batch.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_producer ON tdo.producerid = tfr_producer.id ");
		sql.append("LEFT JOIN t_feed_resource tfr_type ON tdo.typeid = tfr_type.id ");
		sql.append("order by tdo.delivery_date DESC");
		return jdbcTemplate.queryForList(sql.toString());
	}

	public int delDeliveryOrder(String doid) {
		String sql = "delete from t_delivery_order where id = ?";
		return jdbcTemplate.update(sql, doid);
	}

	public DeliveryOrder selectDeliveryOrderById(String doid) {
		String sql = "select id, rsid, spid, batchid, producerid, typeid, use_object userObject, delivery_date deliveryDate, quantity, operator, " +
				"status, remark from t_delivery_order where id = ?";
		List<DeliveryOrder> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<DeliveryOrder>(DeliveryOrder.class),doid);
		return list.isEmpty() ? null : list.get(0);
	}

	public int updateDeliveryOrderStatusToPassed(String doid) {
		String sql = "update t_delivery_order set status = 2 where id = ?";
		return jdbcTemplate.update(sql, doid);
	}

}
