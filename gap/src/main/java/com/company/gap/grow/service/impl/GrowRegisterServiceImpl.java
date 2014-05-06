package com.company.gap.grow.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.gap.backend.company.model.Company;
import com.company.gap.backend.company.service.IBackendCompanyService;
import com.company.gap.base.LocalContext;
import com.company.gap.base.dao.IBaseDao;
import com.company.gap.base.qrcode.TwoDimensionCode;
import com.company.gap.base.service.impl.BaseServiceImpl;
import com.company.gap.base.util.DateUtils;
import com.company.gap.cell.enumeration.CellStatus;
import com.company.gap.cell.service.ICellService;
import com.company.gap.grow.dao.IGrowRegisterDao;
import com.company.gap.grow.enumeration.GrowStatus;
import com.company.gap.grow.model.Register;
import com.company.gap.grow.service.IGrowRegisterService;
import com.company.gap.resource.component.DictHelper;

@Service
public class GrowRegisterServiceImpl extends BaseServiceImpl<Register> implements IGrowRegisterService {

	@Autowired
	private IGrowRegisterDao dao;
	@Autowired
	private ICellService cellService;
	
	@Autowired
	private IBackendCompanyService backendCompanyService;

	@Override
	protected IBaseDao<Register> get() {
		return this.dao;
	}
	
	@Override
	public int save(Register t) {
		
		if (t.getId() == null) {
			t.setGrowstatus(GrowStatus.GOING.getStatus());
		}
		cellService.updateUseStatus(t.getCellId(), CellStatus.OCCUPY.getStatus());
		return super.save(t);
	}

	@Override
	public int deleteById(Integer id) {
		Register t = this.findById(id);
		if (t != null) {
			cellService.updateUseStatus(t.getCellId(), CellStatus.IDLE.getStatus());
		}
		return super.deleteById(id);
	}

	@Override
	public List<Register> findListByGrowStatus(Integer growstatus) {
		Register register = new Register();
		register.setGrowstatus(growstatus);
		return dao.findList(register);
	}
	
	@Override
	public int complete(Integer id) {
		Register t = this.findById(id);
		t.setGrowstatus(GrowStatus.COMPLETED.getStatus());
		
		TwoDimensionCode dimensionCode = new TwoDimensionCode();
		
		Calendar factory = Calendar.getInstance();
		factory.set(Calendar.DATE, -3);
		
		Company c = backendCompanyService.findBean(new Company(LocalContext.getCompanyId()));
		
		String content = new StringBuffer()
			.append("gap://scan/")
			.append(c.getInnercode() + "G" + t.getId()).append("|")//产品编号
			.append(DictHelper.getText(t.getProductId())).append("|")//产品名称
			.append(c.getCompanyname()).append("|")//生产厂家
			.append(DateUtils.format(t.getRegdate()))//.append("|")//生产日期
			//.append(DateUtils.format(factory.getTime()))//出厂日期
			.toString()
		;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		dimensionCode.encoderQRCode(content, output, "png");
		
		t.setQrcode(output.toByteArray());
		
		return dao.update(t);
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
		register.setGrowstatus(GrowStatus.ARCHIVED.getStatus());
		
		return dao.update(register);
	}
}