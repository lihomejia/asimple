package com.company.gap.pesticide.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.pesticide.dao.IPesticideResourceDao;
import com.company.gap.pesticide.model.Resource;

@Repository
public class PesticideResourceDaoImpl extends BaseDaoImpl<Resource> implements IPesticideResourceDao<Resource> {
}
