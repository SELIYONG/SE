package com.se.model;

/**
 * CourseInfoTable entity. @author MyEclipse Persistence Tools
 */

public class CourseInfoTable implements java.io.Serializable {

	// Fields

	private String courseNo;
	private String courseName;
	private Double courseCredit;
	private String courseYear;
	private String courseTerm;

	// Constructors

	/** default constructor */
	public CourseInfoTable() {
	}

	/** full constructor */
	public CourseInfoTable(String courseNo, String courseName,
			Double courseCredit, String courseYear, String courseTerm) {
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseYear = courseYear;
		this.courseTerm = courseTerm;
	}

	// Property accessors

	public String getCourseNo() {
		return this.courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getCourseCredit() {
		return this.courseCredit;
	}

	public void setCourseCredit(Double courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getCourseYear() {
		return this.courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public String getCourseTerm() {
		return this.courseTerm;
	}

	public void setCourseTerm(String courseTerm) {
		this.courseTerm = courseTerm;
	}

}