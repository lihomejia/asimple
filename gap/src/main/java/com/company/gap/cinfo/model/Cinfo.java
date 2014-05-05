package com.company.gap.cinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.company.gap.base.model.GeneralModel;
import com.company.gap.cinfo.enumeration.CinfoType;

@Entity(name="t_cinfo")
public class Cinfo extends GeneralModel {
	
	@Column(length=20, columnDefinition="varchar(20)",updatable=false)
	private CinfoType type;
	
	@Column(length=250)
	private String title;
	
	@Column(length=250)
	private String keyword;
	
	@Column(columnDefinition="TEXT")
	private String content;

	public CinfoType getType() {
		return type;
	}

	public void setType(CinfoType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
