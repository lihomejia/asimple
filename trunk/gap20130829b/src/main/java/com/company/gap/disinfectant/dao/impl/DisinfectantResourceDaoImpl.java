package com.company.gap.disinfectant.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.disinfectant.dao.IDisinfectantResourceDao;
import com.company.gap.disinfectant.model.Resource;

@Repository
public class DisinfectantResourceDaoImpl extends BaseDaoImpl<Resource> implements IDisinfectantResourceDao<Resource> {
}
