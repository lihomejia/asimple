package com.company.gap.resource.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.company.gap.base.model.GeneralModel;
import com.company.gap.resource.enumeration.DictType;

@Entity(name="t_dict")
public class Dict extends GeneralModel {
	
	@Column(length=20, columnDefinition="varchar(20)")
	private DictType type;
	
	@Column(length=100)
	private String name;


	public DictType getType() {
		return type;
	}

	public void setType(DictType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}