package com.company.gap.comp.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.comp.dao.ICompDao;
import com.company.gap.comp.model.Comp;

@Repository
public class CompDaoImpl extends BaseDaoImpl<Comp> implements ICompDao<Comp> {

}
