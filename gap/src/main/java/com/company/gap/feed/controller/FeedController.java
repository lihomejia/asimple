package com.company.gap.feed.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.gap.feed.entity.DeliveryOrder;
import com.company.gap.feed.entity.FeedResource;
import com.company.gap.feed.entity.GodownEntry;
import com.company.gap.feed.entity.Stock;
import com.company.gap.feed.enumeration.FeedResourceEnum;
import com.company.gap.feed.enumeration.ReviewStatus;
import com.company.gap.feed.service.FeedResourceService;
import com.company.gap.feed.service.FeedService;
import com.company.gap.feed.service.StockService;

@Controller
@RequestMapping("/feed")
public class FeedController {
	
	@Autowired
	private FeedResourceService feedResourceService;
	@Autowired
	private FeedService feedService;
	@Autowired
	private StockService stockService;
	/**
	 * 去入库页面
	 */
	@RequestMapping("/toStorage")
	public String toStorage(HttpServletRequest request){
		List<FeedResource> rsList = feedResourceService.findResourceByType(FeedResourceEnum.NAME);
		List<FeedResource> spList = feedResourceService.findResourceByType(FeedResourceEnum.SPECIFICATION);
		List<FeedResource> typeList = feedResourceService.findResourceByType(FeedResourceEnum.TYPE);
		List<FeedResource> batchList = feedResourceService.findResourceByType(FeedResourceEnum.BATCH_NUMBER);
		List<FeedResource> producterList = feedResourceService.findResourceByType(FeedResourceEnum.PRODUCER);
		request.setAttribute("rsList", rsList);
		request.setAttribute("spList", spList);
		request.setAttribute("typeList", typeList);
		request.setAttribute("batchList", batchList);
		request.setAttribute("producterList", producterList);
		return "feed/storage";
	}

	/**
	 * 饲料入库页面
	 */
	@RequestMapping("/storage")
	public String storage(GodownEntry godownEntry){
		String id = UUID.randomUUID().toString();
		int status = ReviewStatus.UNAUDITED.getNumber();
		godownEntry.setId(id);
		godownEntry.setStatus(status);
		feedService.storage(godownEntry);
		return "redirect:/feed/findGodownEntryList.html";
	}
	
	/**
	 * 饲料入库列表
	 */
	@RequestMapping("/findGodownEntryList")
	public String findGodownEntryList(HttpServletRequest request){
		List<Map<String, Object>> godownEntryList = feedService.findGodownEntryList();
		request.setAttribute("gdeList", godownEntryList);
		return "feed/godownEntryList";
	}
	
	/**
	 * 删除入库单
	 */
	@RequestMapping("/deleteGde")
	public String deleteGde(HttpServletRequest request){
		String gdeid = request.getParameter("gdeid");
		feedService.deleteGde(gdeid);
		return "redirect:/feed/findGodownEntryList.html";
	}
	
	/**
	 * 审核通过入库单
	 * <pre>
	 * 1.更改库存
	 * 2.修改入库单审核状态
	 */
	@RequestMapping("/reviewPassGde")
	public String reviewPassGde(HttpServletRequest request){
		String gdeid = request.getParameter("gdeid");
		feedService.reviewPassGde(gdeid);
		return "redirect:/feed/findGodownEntryList.html";
	}
	
	//########################################################################【【库存相关】】#########################################################
	/**
	 * 饲料库存页面
	 */
	@RequestMapping("/stockList")
	public String findStockList(HttpServletRequest request){
		List<Map<String,Object>> stocks = stockService.findAll();
		request.setAttribute("stocks", stocks);
		return "feed/stock/stockList";
	}
	
	/**
	 * 一条库存的入库流水记录
	 */
	public String findStockGodownEntryList(HttpServletRequest request){
		String stockId = request.getParameter("stockid");
		List<GodownEntry> godownEntryList = feedService.findStockGodownEntryList(stockId);
		request.setAttribute("godownEntryList", godownEntryList);
		return "feed/stock/stockGodownEntryList";
	}
	
	/**
	 * 一条库存的出库流水记录
	 */
	public String findStockDeliveryOrderList(HttpServletRequest request){
		String stockId = request.getParameter("stockid");
		List<DeliveryOrder> deliveryOrderList = feedService.findStockDeliveryOrderList(stockId);
		request.setAttribute("deliveryOrderList", deliveryOrderList);
		return "feed/stock/stockGodownEntryList";
	}
	
	//##############################################################################【【以下为出库】】##########################################################
	
	/**
	 * 到出库页面
	 */
	@RequestMapping("/toDelivery")
	public String toDelivery(HttpServletRequest request){
		List<Map<String,Object>> stocks = stockService.findAll();
		request.setAttribute("stocks", stocks);
		return "feed/delivery";
	}
	
	/**
	 * 出库检查
	 */
	@RequestMapping("/checkDelivery")
	public @ResponseBody boolean checkDelivery(HttpServletRequest request){
		String stockId = request.getParameter("stockid");
		int useQuantity = Integer.valueOf(request.getParameter("useQuantity"));
		Stock stock = stockService.findById(stockId);
		return (stock != null) && (stock.getTotalQuantity() >= useQuantity);
	}
	
	/**
	 * 饲料出库记录列表
	 */
	@RequestMapping("/deliverOrderList")
	public String deliverOrderList(HttpServletRequest request){
		List<Map<String, Object>> deliveryOrderList = feedService.findDeliverOrderList();
		request.setAttribute("deliveryOrderList", deliveryOrderList);
		return "feed/deliveryOrderList";
	}
	
	/**
	 * 饲料出库<p>
	 * 1.从库存中减去要出库的数量
	 * 2.插入出库记录
	 */
	@RequestMapping("/delivery")
	public String delivery(HttpServletRequest request, DeliveryOrder order){
		String stockId = request.getParameter("stockid");
		Stock stock = stockService.findById(stockId);
		order.setId(UUID.randomUUID().toString());
		order.setBatchid(stock.getBatchid());
		order.setProducerid(stock.getProducerid());
		order.setRsid(stock.getRsid());
		order.setSpid(stock.getSpid());
		order.setTypeid(stock.getTypeid());
		order.setStatus(ReviewStatus.UNAUDITED.getNumber());
		feedService.delivery(order);
		return "redirect:/feed/deliverOrderList.html";
	}
	
	/**
	 * 出库审核
	 */
	@RequestMapping("/reviewPassDeliveryOrder")
	public String reviewPassDeliveryOrder(HttpServletRequest request){
		String doid = request.getParameter("doid");
		feedService.reviewPassDeliveryOrder(doid);
		return "redirect:/feed/deliverOrderList.html";
	}
	
	/**
	 * 删除出库记录
	 */
	@RequestMapping("/delDeliveryOrder")
	public String delDeliveryOrder(HttpServletRequest request){
		String doid = request.getParameter("doid");
		feedService.delDeliveryOrder(doid);
		return "redirect:/feed/deliverOrderList.html";
	}
}
