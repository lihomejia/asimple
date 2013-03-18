package com.company.gap.feed.service;

import java.util.List;
import java.util.Map;

import com.company.gap.feed.entity.DeliveryOrder;
import com.company.gap.feed.entity.GodownEntry;

public interface FeedService {

	/**
	 * 入库
	 * @param godownEntry 入库单
	 */
	int storage(GodownEntry godownEntry);

	/**
	 * 查询所有的入库单
	 */
	List<Map<String, Object>> findGodownEntryList();

	/**
	 * 删除入库单
	 * @param gdeid 入库单ID
	 */
	int deleteGde(String gdeid);

	/**
	 * 入库单审核通过
	 * @param gdeid 入库单ID
	 */
	boolean reviewPassGde(String gdeid);

	/**
	 * 查询所有的出库单
	 */
	List<Map<String, Object>> findDeliverOrderList();
	
	/**
	 * 出库
	 * @param order 出库单
	 */
	boolean delivery(DeliveryOrder order);

	/**
	 * 出库单审核通过
	 * @param doid 出库单ID
	 */
	int reviewPassDeliveryOrder(String doid);

	/**
	 * 删除出库单
	 */
	boolean delDeliveryOrder(String doid);

	/**
	 * 一条库存的入库流水记录
	 */
	List<GodownEntry> findStockGodownEntryList(String stockId);

	/**
	 * 一条库存的出库流水记录
	 */
	List<DeliveryOrder> findStockDeliveryOrderList(String stockId);

	



}
