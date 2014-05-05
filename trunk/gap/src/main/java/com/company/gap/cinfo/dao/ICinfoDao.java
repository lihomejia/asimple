package com.company.gap.cinfo.dao;

import java.util.List;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.cinfo.enumeration.CinfoType;
import com.company.gap.cinfo.model.Cinfo;

public interface ICinfoDao<T> extends IBaseDao<T> {
	
	List<Cinfo> queryGroup(CinfoType[] types);
}
