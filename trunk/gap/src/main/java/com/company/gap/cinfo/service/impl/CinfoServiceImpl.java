package com.company.gap.cinfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.cinfo.dao.ICinfoDao;
import com.company.gap.cinfo.enumeration.CinfoType;
import com.company.gap.cinfo.model.Cinfo;
import com.company.gap.cinfo.service.ICinfoService;
import com.company.util.New;

@Service
public class CinfoServiceImpl extends BaseServiceImpl<Cinfo> implements ICinfoService {

	@Autowired
	private ICinfoDao<Cinfo> dao;
	
	protected IBaseDao<Cinfo> get() {
		return this.dao;
	}

	@Override
	public Map<CinfoType, List<Cinfo>> queryGroup(CinfoType[] types) {
		
		Map<CinfoType, List<Cinfo>> ret = New.hashMap();
		if (types == null || types.length == 0) return ret;
		
		for (CinfoType type : types) {
			ret.put(type, New.<Cinfo>arrayList());
		}
		
		for (Cinfo info : dao.queryGroup(types)) {
			ret.get(info.getType()).add(info);
		}
		
		return ret;
	}

	@Override
	public Map<CinfoType, List<Cinfo>> queryGroup() {
		return queryGroup(CinfoType.values());
	}
}
