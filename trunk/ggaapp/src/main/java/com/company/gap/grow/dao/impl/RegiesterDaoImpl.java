package com.company.gap.grow.dao.impl;

import org.springframework.stereotype.Repository;

import com.company.gap.base.dao.impl.BaseDaoImpl;
import com.company.gap.grow.dao.IRegisterDao;
import com.company.gap.grow.model.Register;

@Repository
public class RegiesterDaoImpl extends BaseDaoImpl<Register> implements IRegisterDao {
	
	public RegiesterDaoImpl() {
		super(Register.class);
	}
}
