package com.company.gap.info.service;

import java.util.List;
import java.util.Map;

import com.company.gap.base.service.IBaseService;
import com.company.gap.info.enumeration.InfoType;
import com.company.gap.info.model.Info;

public interface IInfoService extends IBaseService<Info> {
	
	Map<InfoType, List<Info>> queryGroup(InfoType[] types);
	
	Map<InfoType, List<Info>> queryGroup();
}