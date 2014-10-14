package com.company.gap.disinfectant.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_disinfectant_use")
public class Use extends GeneralModel {
	@Column(name="register_id", columnDefinition="int default 0")
	private Integer registerId;
	
	@Column(name="cell_id", columnDefinition="int default 0")
	private Integer cellId;

	public Integer getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getCellId() {
		return cellId;
	}

	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}
	
}
