package com.se.model;

public class StudentCourseScore {

	private String stuNo;
	private String stuName;
	private String courseNo;
	private String courseName;
	private double score;
	public StudentCourseScore(String stuNo,String stuName,String courseNo,String courseName,double score){
		this.courseName = courseName;
		this.courseNo = courseNo;
		this.score = score;
		this.stuName = stuName;
		this.stuNo = stuNo;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
