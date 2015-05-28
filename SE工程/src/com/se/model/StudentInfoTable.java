package com.se.model;

/**
 * StudentInfoTable entity. @author MyEclipse Persistence Tools
 */

public class StudentInfoTable implements java.io.Serializable {

	// Fields

	private String stuNo;
	private String stuName;
	private String stuIdnumber;
	private String stuSex;
	private String stuDepartment;
	private String stuClassNo;
	private String stuNativePlace;
	private String stuTelephone;

	// Constructors

	/** default constructor */
	public StudentInfoTable() {
	}

	/** minimal constructor */
	public StudentInfoTable(String stuNo, String stuName, String stuIdnumber,
			String stuSex, String stuDepartment, String stuClassNo,
			String stuNativePlace) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuIdnumber = stuIdnumber;
		this.stuSex = stuSex;
		this.stuDepartment = stuDepartment;
		this.stuClassNo = stuClassNo;
		this.stuNativePlace = stuNativePlace;
	}

	/** full constructor */
	public StudentInfoTable(String stuNo, String stuName, String stuIdnumber,
			String stuSex, String stuDepartment, String stuClassNo,
			String stuNativePlace, String stuTelephone) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuIdnumber = stuIdnumber;
		this.stuSex = stuSex;
		this.stuDepartment = stuDepartment;
		this.stuClassNo = stuClassNo;
		this.stuNativePlace = stuNativePlace;
		this.stuTelephone = stuTelephone;
	}

	// Property accessors

	public String getStuNo() {
		return this.stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuIdnumber() {
		return this.stuIdnumber;
	}

	public void setStuIdnumber(String stuIdnumber) {
		this.stuIdnumber = stuIdnumber;
	}

	public String getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuDepartment() {
		return this.stuDepartment;
	}

	public void setStuDepartment(String stuDepartment) {
		this.stuDepartment = stuDepartment;
	}

	public String getStuClassNo() {
		return this.stuClassNo;
	}

	public void setStuClassNo(String stuClassNo) {
		this.stuClassNo = stuClassNo;
	}

	public String getStuNativePlace() {
		return this.stuNativePlace;
	}

	public void setStuNativePlace(String stuNativePlace) {
		this.stuNativePlace = stuNativePlace;
	}

	public String getStuTelephone() {
		return this.stuTelephone;
	}

	public void setStuTelephone(String stuTelephone) {
		this.stuTelephone = stuTelephone;
	}

}