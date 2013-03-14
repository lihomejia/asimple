package com.company.gap.base.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.gap.base.dao.search.Pager;
import com.company.gap.base.dao.search.Searcher;
import com.company.gap.base.dao.search.SimpleSearcher;
import com.company.gap.base.service.IViewService;

public abstract class ViewController {

	private static final long serialVersionUID = 1L;
	
	public static final String ACT_DELETE = "delete";
	public static final String ACT_GOPAGE = "gopage";
	public static final String ACT_SEARCH = "search";
	public static final String ACT_SELECT = "select";
	
	@Autowired
	private IViewService viewService;
	
	protected String _action;
	
	/** 查询到的结果数据集 */
	@SuppressWarnings("unchecked")
	protected List datas;
	/** 翻页控制器 */
	protected Pager pager;
	/** 查询器 */
	protected Searcher searcher;
	
	
	@RequestMapping("list")
	public String execute(HttpServletRequest request) {
		
		dowithSearcher();
		
		this.datas = viewService.queryList(searcher);
		
		request.setAttribute("datas", datas);
		
		pager = searcher.getPager();
		pager.setStart(16);
		pager.setPage(2);
		pager.setPages(10);
		pager.setHits(15);
		pager.setAllhits(145);
		pager.setCount(15);
		
		request.setAttribute("pager", pager);
		
		return rootRequestMapping() + "List";
	}
	
	@RequestMapping("delete")
	public String doDelete(HttpServletRequest request) {
		_action = ACT_DELETE;
		return execute(request);
	}

	@RequestMapping("gopage")
	public String doGopage(HttpServletRequest request, Pager pager) {
		System.out.println(request.getParameter("pager.start"));
		_action = ACT_GOPAGE;
		return execute(request);
	}

	@RequestMapping("search")
	public String doSearch(HttpServletRequest request){
		_action = ACT_SEARCH;
		return execute(request);
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

	}

	protected abstract String rootRequestMapping();
	
	public Searcher getDefaultSearcher() {
		return new SimpleSearcher();
	}
	

	/*********************Getter && Setter**************************/
	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
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