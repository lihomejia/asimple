package com.company.gap.disinfectant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.company.gap.base.controller.ControllerSupport;
import com.company.gap.base.model.GeneralModel;
import com.company.gap.disinfectant.enumeration.DisinfectantResourceType;

@Entity(name="t_disinfectant_resource")
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
	private DisinfectantResourceType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DisinfectantResourceType getType() {
		return type;
	}

	public void setType(DisinfectantResourceType type) {
		this.type = type;
	}
}