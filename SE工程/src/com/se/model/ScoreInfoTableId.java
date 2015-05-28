package com.se.model;

/**
 * ScoreInfoTableId entity. @author MyEclipse Persistence Tools
 */

public class ScoreInfoTableId implements java.io.Serializable {

	// Fields

	private String courseNo;
	private String stuNo;

	// Constructors

	/** default constructor */
	public ScoreInfoTableId() {
	}

	/** full constructor */
	public ScoreInfoTableId(String courseNo, String stuNo) {
		this.courseNo = courseNo;
		this.stuNo = stuNo;
	}

	// Property accessors

	public String getCourseNo() {
		return this.courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getStuNo() {
		return this.stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScoreInfoTableId))
			return false;
		ScoreInfoTableId castOther = (ScoreInfoTableId) other;

		return ((this.getCourseNo() == castOther.getCourseNo()) || (this
				.getCourseNo() != null && castOther.getCourseNo() != null && this
				.getCourseNo().equals(castOther.getCourseNo())))
				&& ((this.getStuNo() == castOther.getStuNo()) || (this
						.getStuNo() != null && castOther.getStuNo() != null && this
						.getStuNo().equals(castOther.getStuNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCourseNo() == null ? 0 : this.getCourseNo().hashCode());
		result = 37 * result
				+ (getStuNo() == null ? 0 : this.getStuNo().hashCode());
		return result;
	}

}