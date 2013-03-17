package com.company.gap.cell.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.controller.ViewController;
import com.company.gap.base.dao.search.SimpleSearcher;
import com.company.gap.base.entity.FormModel;
import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.service.ICellService;

/**
 * 
 * @author lh.jia
 *
 */
@Controller
@RequestMapping("cell")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CellController extends ViewController {
	
	@Autowired
	private ICellService cellService;
	
	@Override
	protected void dowithSearcher() {
		super.dowithSearcher();
		
		SimpleSearcher ss = (SimpleSearcher) searcher;
		
		
		ss.setTable("t_production_cell");
	}
	
	@Override
	protected void afterall() {
		for (Map<String, Object> data : this.datas) {
			data.put("cell_cdate", DateUtils.format(data.get("cell_cdate")));
		}
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		return "cell/entry";
	}

	@RequestMapping("save")
	public String save(HttpServletRequest request, FormModel model) {
		cellService.saveCell(model.getData());
		return "redirect:/cell/list.html";
	}
	
	@RequestMapping("entry")
	public String entry(HttpServletRequest request, @RequestParam("cellId") int cellId) {
		Map<String, Object> data = this.cellService.findProductionCellById(cellId);
		data.put("cell_cdate", DateUtils.format(data.get("cell_cdate")));
		request.setAttribute("data", data);
		return "cell/entry";
	}
	

	@Override
	protected String rootRequestMapping() {
		return "cell/list";
	}
}