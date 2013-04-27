package com.company.gap.feed.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_feed_resource")
public class Resource extends GeneralModel {
	
	@Column(length=60)
	private String name;
	
	@Column(columnDefinition="int default 0")
	private Integer type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
