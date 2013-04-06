package com.company.gap.grow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.base.util.Dto;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.dao.IGrowRegisterDao;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.grow.tab.TRegister;

@Service
public class GrowRegisterServiceImpl implements IGrowRegisterService {

	@Autowired
	private IGrowRegisterDao registerDao;
	@Autowired
	private ICellService cellService;
	
	@Override
	public Dto findGrowRegister(int registerId) {
		return registerDao.findGrowRegister(registerId);
	}

	@Override
	public int save(Dto register) {
		int ret = 0;
		if (register.getInt(TRegister.ID) == 0) {
			ret = registerDao.insert(register);
			cellService.updateStatus(register.getInt(TRegister.CELLID), CellStatus.OCCUPY.getStatus());
		}
		else {
			ret = registerDao.update(register);
		}
		return ret;
	}
	
	@Override
	public int auditing(int registerId) {
		return registerDao.auditing(registerId);
	}

	@Override
	public int complete(int registerId) {
		return registerDao.complete(registerId);
	}

	@Override
	public int archive(int registerId) {
		return registerDao.archive(registerId);
	}
	
	@Override
	public int delete(int registerId) {
		Dto register = this.findGrowRegister(registerId);
		int ret = registerDao.delete(registerId);
		cellService.updateStatus(register.getInt(TRegister.CELLID), CellStatus.IDLE.getStatus());
		return ret;
	}

	@Override
	public List<Dto> findGrowingInfos() {
		return registerDao.findGrowingInfos();
	}
}
