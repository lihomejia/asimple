package com.company.gap.manure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.company.gap.base.controller.ControllerSupport;
import com.company.gap.base.model.GeneralModel;
import com.company.gap.manure.enumeration.ManureResourceType;

@Entity(name="t_manure_resource")
public class Resource extends GeneralModel {
	
	@Transient
	public static final Resource RS_ALL = new Resource(ControllerSupport.__ALL);
	
	public Resource() {}

	public Resource(String name) {
		this.name = name;
	}

	@Column(length=60)
	private String name;
	
	@Column(length=20, columnDefinition="varchar(20)",updatable=false)
	private ManureResourceType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManureResourceType getType() {
		return type;
	}

	public void setType(ManureResourceType type) {
		this.type = type;
	}
}