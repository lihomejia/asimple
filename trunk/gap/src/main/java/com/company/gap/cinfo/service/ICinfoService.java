package com.company.gap.cinfo.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.service.IBaseService;
import com.company.gap.cinfo.enumeration.CinfoType;
import com.company.gap.cinfo.model.Cinfo;

public interface ICinfoService extends IBaseService<Cinfo> {
	
	Map<CinfoType, List<Cinfo>> queryGroup(CinfoType[] types);
	
	Map<CinfoType, List<Cinfo>> queryGroup();
}