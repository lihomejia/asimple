package com.company.gap.base.service.impl;

import java.util.Date;
import java.util.List;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.model.GeneralModel;
import com.company.gap.base.model.Status;
import com.company.gap.base.service.IBaseService;

public abstract class BaseServiceImpl<T extends GeneralModel> implements IBaseService<T> {
	
	protected abstract IBaseDao<T> get();

	@Override
	public int save(T t) {
		return get().insert(t);
	}
	
	@Override
	public int update(T t) {
		return get().update(t);
	}
	
	@Override
	public int updateStatus(Integer id, Integer status) {
		return get().updateStatus(id, status);
	}
	
	@Override
	public int updateStatus(Integer id, Integer status, Integer cuserId, Date cdate) {
		return get().updateStatus(id, status, cuserId, cdate);
	}
	
	@Override
	public int deleteById(Integer id) {
		return get().deleteById(id);
	}
	
	@Override
	public int approve(Integer id) {
		return get().updateStatus(id, Status.APPROVED.getStatus());
	}
	
	@Override
	public int nullify(Integer id) {
		return get().updateStatus(id, Status.NULLIFY.getStatus());
	}
	
	@Override
	public List<T> findList() {
		return get().findList();
	}
	
	@Override
	public List<T> findList(T t) {
		return get().findList(t);
	}

	@Override
	public List<T> findList(String sql, Object... args) {
		return get().findList(sql, args);
	}
	
	@Override
	public T findById(Integer id) {
		return get().findById(id);
	}
	
	@Override
	public T findBean(T t) {
		return get().findBean(t);
	}
	
	@Override
	public T findBean(String sql, Object... args) {
		return get().findBean(sql, args);
	}
}