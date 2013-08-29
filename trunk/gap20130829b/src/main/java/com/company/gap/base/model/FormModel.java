package com.company.gap.base.model;

import com.company.gap.base.util.BaseDto;
import com.company.gap.base.util.Dto;

public class FormModel {
	private Dto data = new BaseDto();

	public Dto getData() {
		return data;
	}

	public void setData(Dto data) {
		this.data = data;
	}
}