package com.company.gap.grow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.model.Status;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.dao.IRegisterDao;
import com.company.gap.grow.enumeration.GrowStatus;
import com.company.gap.grow.model.Register;
import com.company.gap.grow.service.IRegisterService;

@Service
public class RegisterServiceImpl extends BaseServiceImpl<Register> implements IRegisterService {

	@Autowired
	private IRegisterDao dao;
	@Autowired
	private ICellService cellService;

	@Override
	protected IBaseDao<Register> get() {
		return this.dao;
	}
	
	@Override
	public int save(Register register) {
		int ret = 0;
		if (register.getId() == null) {
			ret = dao.insert(register);
			cellService.updateStatus(register.getCellId(), CellStatus.OCCUPY.getStatus());
		}
		else {
			ret = dao.update(register);
		}
		return ret;
	}
	
	@Override
	public List<Register> findListByGrowStatus(Integer growstatus) {
		Register register = new Register();
		register.setGrowstatus(growstatus);
		return dao.findList(register);
	}

	@Override
	public int approve(Integer id) {
		Register register = new Register();
		register.setId(id);
		register.setStatus(Status.APPROVED.getStatus());
		
		return dao.update(register);
	}
	
	@Override
	public int complete(Integer id) {
		Register register = new Register();
		register.setId(id);
		register.setGrowstatus(GrowStatus.COMPLETED.getStatus());
		
		return dao.update(register);
	}

	@Override
	public int archive(Integer id) {
		Register register = new Register();
		register.setId(id);
		register.setGrowstatus(GrowStatus.ARCHIVED.getStatus());
		
		return dao.update(register);
	}

	
}