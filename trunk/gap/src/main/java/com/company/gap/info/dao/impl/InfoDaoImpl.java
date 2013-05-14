package com.company.gap.info.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.info.dao.IInfoDao;
import com.company.gap.info.model.Info;

@Repository
public class InfoDaoImpl extends BaseDaoImpl<Info> implements IInfoDao<Info> {
}
