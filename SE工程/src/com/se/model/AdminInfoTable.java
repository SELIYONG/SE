package com.se.model;

/**
 * AdminInfoTable entity. @author MyEclipse Persistence Tools
 */

public class AdminInfoTable implements java.io.Serializable {

	// Fields

	private String adminId;
	private String adminPassword;
	private String adminTypeId;

	// Constructors

	/** default constructor */
	public AdminInfoTable() {
	}

	/** full constructor */
	public AdminInfoTable(String adminId, String adminPassword,
			String adminTypeId) {
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminTypeId = adminTypeId;
	}

	// Property accessors

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminTypeId() {
		return this.adminTypeId;
	}

	public void setAdminTypeId(String adminTypeId) {
		this.adminTypeId = adminTypeId;
	}

}