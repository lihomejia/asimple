package com.company.gap.base.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.Searcher;
import com.company.gap.base.dao.search.SimpleSearcher;
import com.company.gap.base.entity.ViewFormModel;
import com.company.gap.base.service.IViewService;

public abstract class ViewController<T> {

	private static final long serialVersionUID = 1L;
	
	public static final String ACT_DELETE = "delete";
	public static final String ACT_GOPAGE = "gopage";
	public static final String ACT_SEARCH = "search";
	public static final String ACT_SELECT = "select";
	
	@Autowired
	private IViewService<T> viewService;
	
	protected String _action;
	
	/** 查询到的结果数据集 */
	protected List<T> datas;
	/** 翻页控制器 */
	protected Pager pager;
	/** 查询器 */
	protected Searcher searcher;
	
	@RequestMapping("list")
	public String execute(HttpServletRequest request, ViewFormModel model) {
		/**  */
		this.searcher = model.getSearcher();
		this.pager = model.getPager();
		
		dowithSearcher();
		
		this.datas = viewService.queryList(searcher);
		
		request.setAttribute("datas", datas);
		
		request.setAttribute("pager", searcher.getPager());
		
		return rootRequestMapping() + "List";
	}
	
	@RequestMapping("delete")
	public String doDelete(HttpServletRequest request, ViewFormModel model) {
		_action = ACT_DELETE;
		return execute(request, model);
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
	
	protected void dowithSearcher(){
		// 新search,删除原来的，保存新的
		if (ACT_SEARCH.equals(_action)){
			//SearcherHelper.decacheSearcher(this);
			//SearcherHelper.cacheSearcher(this);
		}
		// gopage / delete, do nothing with searcher
		//  因为这两个操作,都是在search操作完成以后
		else if (
			ACT_GOPAGE.equals(_action) ||
			ACT_DELETE.equals(_action)
		){
			//SearcherHelper.initSearcher(this);
		}
		
		// 无论如何,确保searcher和pager正常初始化.
		//  在正式查询之前,有类似代码.
		if (searcher == null){
			searcher = getDefaultSearcher();
		}		
		if (pager == null){
			pager = searcher.getPager();
			if (pager == null){
				pager = Pager.getDefault();
			}
		}
		if(ACT_SEARCH.equals(_action)){
			pager = searcher.getPager();
			if (pager == null){
				pager = Pager.getDefault();
			}
		}
		searcher.setPager(pager);
		searcher.setTablename(getTableName());

	}

	protected abstract String rootRequestMapping();
	protected abstract String getTableName();
	
	public Searcher getDefaultSearcher() {
		return new SimpleSearcher();
	}
	

	/*********************Getter && Setter**************************/
	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Searcher getSearcher() {
		if (searcher == null){
			searcher = getDefaultSearcher();
		}
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}
}