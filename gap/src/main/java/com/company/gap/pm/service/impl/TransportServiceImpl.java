package com.company.gap.pm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.pm.dao.ITransportDao;
import com.company.gap.pm.model.Transport;
import com.company.gap.pm.service.ITransportService;

@Service
public class TransportServiceImpl extends BaseServiceImpl<Transport> implements ITransportService {

	@Autowired
	private ITransportDao<Transport> dao;
	

	@Override
	protected IBaseDao<Transport> get() {
		return this.dao;
	}

}
