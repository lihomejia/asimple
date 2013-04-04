package com.company.gap.grow.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.dao.IGrowRegisterDao;
import com.company.gap.grow.entity.GrowRegister;
import com.company.gap.grow.service.IGrowRegisterService;

@Service
public class GrowRegisterServiceImpl implements IGrowRegisterService {

	@Autowired
	private IGrowRegisterDao registerDao;
	@Autowired
	private ICellService cellService;
	
	@Override
	public GrowRegister findGrowRegister(int registerId) {
		return registerDao.findGrowRegister(registerId);
	}

	@Override
	public int save(GrowRegister register) {
		int ret = 0;
		if (register.getRegister_id() == 0) {
			ret = registerDao.insert(register);
			cellService.updateStatus(register.getRegister_cellid(), CellStatus.OCCUPY.getStatus());
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
		GrowRegister register = this.findGrowRegister(registerId);
		int ret = registerDao.delete(registerId);
		cellService.updateStatus(register.getRegister_cellid(), CellStatus.IDLE.getStatus());
		return ret;
	}

	@Override
	public List<Map<String, Object>> findGrowingInfos() {
		return registerDao.findGrowingInfos();
	}
}
