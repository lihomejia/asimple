package com.company.gap.base.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Entry界面基类.
 * @author lh.jia
 *
 */
public class EntryController extends BaseController {
	
	/**
	 * 新建
	 * @param request
	 * @return
	 */
	public String add(HttpServletRequest request) {
		this._action = ACT_ADD;
		this.initialize(request);
		this.initializeAdd(request);
		return null;
	}
	
	/**
	 * 编辑.
	 * @param request
	 * @return
	 */
	public String edit(HttpServletRequest request) {
		this._action = ACT_EDIT;
		this.initialize(request);
		this.initializeEdit(request);
		return null;
	}
	
	/**
	 * 显示.
	 * @param request
	 * @return
	 */
	public String disp(HttpServletRequest request) {
		this._action = ACT_DISP;
		this.initialize(request);
		this.initializeDisp(request);
		return null;
	}
	

	/**
	 * 保存操作.
	 * @param request
	 * @return
	 */
	public String save(HttpServletRequest request) {
		return null;
	}
	
	/**
	 * 更新操作.
	 * 仅当 新建与修改 逻辑差距较大的情况下需使用.
	 * @param request
	 * @return
	 */
	public String update(HttpServletRequest request) {
		return null;
	}
	
	/**
	 * 删除操作.
	 * @param request
	 * @return
	 */
	public String delete(HttpServletRequest request) {
		return null;
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
	protected void initializeEdit(HttpServletRequest request) {}
	/** 初始化与显示有关的资源 */
	protected void initializeDisp(HttpServletRequest request) {}
}
