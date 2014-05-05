package com.company.gap.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.company.gap.base.model.GeneralModel;

@Entity(name="t_user")
public class User extends GeneralModel {
	
	/**
	 * 仅用于登录.
	 */
	@Column(name="user_id", length=20)
	private String userId;
	
	@Column(name="user_name", length=60)
	private String userName;
	
	@Column(name="pass_word", length=20)
	private String passWord;
	
	@Transient
	private String companyId;
	
	@Transient
	private Integer companyType;
	
	/**
	 * 1: backend
	 * 2: admin
	 */
	@Transient
	private int userType;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public Integer getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
}