package com.company.gap.feed.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.feed.dao.FeedDao;
import com.company.gap.feed.dao.StockDao;
import com.company.gap.feed.entity.DeliveryOrder;
import com.company.gap.feed.entity.GodownEntry;
import com.company.gap.feed.entity.Stock;
import com.company.gap.feed.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	private FeedDao feedDao;
	@Autowired
	private StockDao stockDao;
	
	@Override
	public int storage(GodownEntry godownEntry) {
		return feedDao.insertGodownEntry(godownEntry);
	}

	@Override
	public List<Map<String, Object>> findGodownEntryList() {
		return feedDao.selectGodownEntryList();
	}
	
	@Override
	public int deleteGde(String gdeid) {
		return feedDao.deleteGde(gdeid);
	}

	@Override
	public boolean reviewPassGde(String gdeid) {
		GodownEntry godownEntry = feedDao.selectGodownEntryById(gdeid);
		Stock stock = stockDao.selectOnlyStock(godownEntry.getRsid(),
				godownEntry.getSpid(), godownEntry.getBatchid(), godownEntry
						.getProducerid(), godownEntry.getTypeid());
		int z = 0;
		if(stock != null){
			z = stockDao.addQuantity(godownEntry.getQuantity(), stock.getId());
		}else {
			stock = new Stock();
			stock.setId(UUID.randomUUID().toString());
			stock.setBatchid(godownEntry.getBatchid());
			stock.setProducerid(godownEntry.getProducerid());
			stock.setRsid(godownEntry.getRsid());
			stock.setSpid(godownEntry.getSpid());
			stock.setTotalQuantity(godownEntry.getQuantity());
			stock.setTypeid(godownEntry.getTypeid());
			z = stockDao.insert(stock);
		}
		int r = feedDao.updateGdeStatusToPassed(gdeid);
		return (z == 1) && (r == 1);
	}
	
	@Override
	public List<GodownEntry> findStockGodownEntryList(String stockId) {
		return null;
	}
	
	@Override
	public List<DeliveryOrder> findStockDeliveryOrderList(String stockId) {
		return null;
	}

	@Override
	public List<Map<String, Object>> findDeliverOrderList() {
		return feedDao.selectDeliverOrderList();
	}
	
	/**
	 * 饲料出库<p>
	 * 1.从库存中减去要出库的数量，若库存总量为零了，则删除库存。
	 * 2.插入出库记录
	 */
	@Override
	public boolean delivery(DeliveryOrder deliveryOrder) {
		int r = 0;
		Stock stock = stockDao.selectOnlyStock(deliveryOrder.getRsid(),
				deliveryOrder.getSpid(), deliveryOrder.getBatchid(),
				deliveryOrder.getProducerid(), deliveryOrder.getTypeid());
		int surplus = stock.getTotalQuantity() - deliveryOrder.getQuantity();
		if(surplus <= 0){
			r = stockDao.deleteById(stock.getId());
		}else{
			r = stockDao.subQuantity(stock.getId(),deliveryOrder.getQuantity());
		}
		int c = feedDao.insertDeliveryOrder(deliveryOrder);
		return (r == 1) && (c == 1);
	}

	/**
	 * 出库审核<p>
	 * 因为在之前，就做了库存量验证。所以这里仅需要1步：
	 * 1.修改出库单状态
	 */
	@Override
	public int reviewPassDeliveryOrder(String doid) {
		return feedDao.updateDeliveryOrderStatusToPassed(doid);
	}
	
	/**
	 * 删除出库单<p>
	 * 因为在生成出库单时，是在总库存上除去了该出库单数量的。
	 * 因此，当审核不通过，要删除该单据时，得需要把之前扣除的填补回来。
	 * <pre>
	 * 步骤如下：
	 * 1.判断库存中是否还有该饲料品种的库存，有则加上库存，没有则插入扣除的库存。
	 * 2.删除出库单
	 */
	@Override
	public boolean delDeliveryOrder(String doid) {
		int r = 0;
		DeliveryOrder deliveryOrder = feedDao.selectDeliveryOrderById(doid);
		Stock stock = stockDao.selectOnlyStock(deliveryOrder.getRsid(),
				deliveryOrder.getSpid(), deliveryOrder.getBatchid(),
				deliveryOrder.getProducerid(), deliveryOrder.getTypeid());
		if(stock == null){
			stock = new Stock();
			stock.setId(UUID.randomUUID().toString());
			stock.setBatchid(deliveryOrder.getBatchid());
			stock.setProducerid(deliveryOrder.getProducerid());
			stock.setRsid(deliveryOrder.getRsid());
			stock.setSpid(deliveryOrder.getSpid());
			stock.setTotalQuantity(deliveryOrder.getQuantity());
			stock.setTypeid(deliveryOrder.getTypeid());
			r = stockDao.insert(stock);
		}else {
			r = stockDao.addQuantity(deliveryOrder.getQuantity(), stock.getId());
		}
		int c = feedDao.delDeliveryOrder(doid);
		return (r == 1) && (c == 1);
	}
}
