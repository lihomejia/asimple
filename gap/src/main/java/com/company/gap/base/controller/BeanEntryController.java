package com.company.gap.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.gap.base.model.Status;
import com.company.gap.base.service.IBaseService;

/**
 * Entry界面基类.
 * @author lh.jia
 *
 */
public class BeanEntryController<T> extends BaseController {
	
	protected IBaseService<T> get() {return null;}
	protected String toList(HttpServletRequest request) {return null;}
	protected String toEntry(HttpServletRequest request) {return null;}
	
	/**
	 * 新建
	 * @param request
	 * @return
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request) {
		this._action = ACT_ADD;
		this.initialize(request);
		this.initializeAdd(request);
		return this.toEntry(request);
	}
	
	/**
	 * 编辑.
	 * @param request
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(HttpServletRequest request, @RequestParam("id") Integer id) {
		this._action = ACT_EDIT;
		T t = get().findById(id);
		this.initialize(request);
		this.initializeEdit(request, t);
		return this.toEntry(request);
	}
	
	/**
	 * 显示.
	 * @param request
	 * @return
	 */
	@RequestMapping("disp")
	public String disp(HttpServletRequest request, @RequestParam("id") Integer id) {
		this._action = ACT_DISP;
		T t = get().findById(id);
		this.initialize(request);
		this.initializeDisp(request, t);
		return this.toEntry(request);
	}

	/**
	 * 保存操作.
	 * @param request
	 * @return
	 */
	@RequestMapping("save")
	public String save(HttpServletRequest request, T t) {
		this.get().save(t);
		return this.toList(request);
	}
	
	/**
	 * 更新操作.
	 * @param request
	 * @return
	 */
	@RequestMapping("update")
	public String update(HttpServletRequest request, T t) {
		this.get().update(t);
		return this.toList(request);
	}
	
	/**
	 * 删除操作.
	 * @param request
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Integer id) {
		this.get().deleteById(id);
		return toList(request);
	}
	
	
	@RequestMapping("approve")
	public String approve(HttpServletRequest request, @RequestParam("id") Integer id) {
		this.get().updateStatus(id, Status.APPROVED.getStatus());
		return toList(request);
	}
	
	@RequestMapping("nullify")
	public String nullify(HttpServletRequest request, @RequestParam("id") Integer id) {
		this.get().updateStatus(id, Status.NULLIFY.getStatus());
		return toList(request);
	}
	
	/**
	 * 初始化(如新建、编辑、显示)公共资源.
	 * @param request
	 */
	protected void initialize(HttpServletRequest request) {
		request.setAttribute(ACT_NAME, this._action);
	}
	
	/** 初始化与新建有关的资源 */
	protected void initializeAdd(HttpServletRequest request) {}
	/** 初始化与编辑有关的资源 */
	protected void initializeEdit(HttpServletRequest request, T t) {
		request.setAttribute("data", t);
	}
	/** 初始化与显示有关的资源 */
	protected void initializeDisp(HttpServletRequest request, T t) {
		/**默认与编辑页面逻辑一致*/
		this.initializeEdit(request, t);
	}
}
