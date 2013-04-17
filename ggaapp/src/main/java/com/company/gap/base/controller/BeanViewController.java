package com.company.gap.base.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.SimpleSearcher;
import com.company.gap.base.model.GeneralModelUtil;
import com.company.gap.base.model.ViewFormModel;
import com.company.gap.base.service.IBeanViewService;

public abstract class BeanViewController<T> extends BaseController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IBeanViewService<T> viewService;
	
	/** 查询到的结果数据集 */
	protected List<T> datas;
	/** 翻页控制器 */
	protected Pager pager;
	/** 查询器 */
	protected SimpleSearcher searcher;
	
	private Class<T> clazz;
	
	public BeanViewController(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping("list")
	public String execute(HttpServletRequest request, ViewFormModel model) {
		
		this.initialize(request, model);
		
		this.preparing(request, model);
		
		this.dowithSearcher(request, model);
		
		this.searching(request, model);
		
		this.fill(request, model);
		
		this.afterall(request, model);
		
		return viewResolver(request, model);
	}
	
	@RequestMapping("gopage")
	public String doGopage(HttpServletRequest request, ViewFormModel model) {
		_action = ACT_GOPAGE;
		return execute(request, model);
	}

	@RequestMapping("search")
	public String doSearch(HttpServletRequest request, ViewFormModel model){
		_action = ACT_SEARCH;
		return execute(request, model);
	}
	
	/**
	 * 初始化参数.
	 */
	private void initialize(HttpServletRequest request, ViewFormModel model) {
		this.searcher = model.getSearcher();
		this.pager = model.getPager();
		if (searcher == null){
			searcher = new SimpleSearcher();
		}
		searcher.setTable(GeneralModelUtil.getTableName(this.clazz));
		if (pager == null) {
			pager = Pager.getDefault();
		}
	}
	
	/** 
	 * 准备其他数据.
	 */
	protected void preparing(HttpServletRequest request, ViewFormModel model) {}
	
	/**
	 * Searcher加工.
	 */
	protected void dowithSearcher(HttpServletRequest request, ViewFormModel model){}
	
	/**
	 * 执行查询.
	 */
	protected void searching(HttpServletRequest request, ViewFormModel model) {
		this.datas = viewService.queryList(searcher, pager, clazz);
	}
	
	/**
	 * 填充数据，供前台使用.
	 */
	protected void fill(HttpServletRequest request, ViewFormModel model) {
		request.setAttribute("data", 		model.getData());
		request.setAttribute("datas", 		datas);
		request.setAttribute("searcher",	searcher);
		request.setAttribute("pager", 		pager);
	}
	
	/** 
	 * 呈现之前的最后处理.
	 */
	protected void afterall(HttpServletRequest request, ViewFormModel model) {}
	
	/**
	 * 指定要呈现的View.
	 */
	protected abstract String viewResolver(HttpServletRequest request, ViewFormModel model);
}