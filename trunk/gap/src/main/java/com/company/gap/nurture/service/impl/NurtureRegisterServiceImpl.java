package com.company.gap.nurture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;
import com.company.gap.nurture.dao.INurtureRegisterDao;
import com.company.gap.nurture.enumeration.NurtureStatus;
import com.company.gap.nurture.model.Register;
import com.company.gap.nurture.service.INurtureRegisterService;

@Service
public class NurtureRegisterServiceImpl extends BaseServiceImpl<Register> implements INurtureRegisterService {

	@Autowired
	private INurtureRegisterDao dao;
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
			register.setNurturestatus(NurtureStatus.GOING.getStatus());
			ret = dao.insert(register);
			cellService.updateUseStatus(register.getCellId(), CellStatus.OCCUPY.getStatus());
		}
		else {
			ret = dao.update(register);
		}
		return ret;
	}
	
	@Override
	public List<Register> findListByNurtureStatus(Integer nurturestatus) {
		Register register = new Register();
		register.setNurturestatus(nurturestatus);
		return dao.findList(register);
	}
	
	@Override
	public int complete(Integer id) {
		Register register = new Register();
		register.setId(id);
		register.setNurturestatus(NurtureStatus.COMPLETED.getStatus());
		
		return dao.update(register);
	}
	

	@Override
	public int nullify(Integer id) {
		Register register = dao.findById(id);
		cellService.updateUseStatus(register.getCellId(), CellStatus.IDLE.getStatus());
		return super.nullify(id);
	}

	@Override
	public int archive(Integer id) {
		
		Register register = dao.findById(id);
		cellService.updateUseStatus(register.getCellId(), CellStatus.IDLE.getStatus());
		
		register = new Register();
		register.setId(id);
		register.setNurturestatus(NurtureStatus.ARCHIVED.getStatus());
		
		return dao.update(register);
	}
}