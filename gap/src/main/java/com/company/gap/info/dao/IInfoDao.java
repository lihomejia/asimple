package com.company.gap.info.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.info.enumeration.InfoType;
import com.company.gap.info.model.Info;

public interface IInfoDao<T> extends IBaseDao<T> {
	
	List<Info> queryGroup(InfoType[] types);
}
