package com.company.gap.info.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.info.dao.IInfoDao;
import com.company.gap.info.enumeration.InfoType;
import com.company.gap.info.model.Info;
import com.company.gap.info.service.IInfoService;
import com.company.util.New;

@Service
public class InfoServiceImpl extends BaseServiceImpl<Info> implements IInfoService {

	@Autowired
	private IInfoDao<Info> dao;
	
	protected IBaseDao<Info> get() {
		return this.dao;
	}

	@Override
	public Map<InfoType, List<Info>> queryGroup(InfoType[] types) {
		
		Map<InfoType, List<Info>> ret = New.hashMap();
		if (types == null || types.length == 0) return ret;
		
		for (InfoType type : types) {
			ret.put(type, New.<Info>arrayList());
		}
		
		for (Info info : dao.queryGroup(types)) {
			ret.get(info.getType()).add(info);
		}
		
		return ret;
	}

	@Override
	public Map<InfoType, List<Info>> queryGroup() {
		return queryGroup(InfoType.values());
	}
}
