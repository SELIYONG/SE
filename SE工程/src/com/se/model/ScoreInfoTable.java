package com.se.model;

/**
 * ScoreInfoTable entity. @author MyEclipse Persistence Tools
 */

public class ScoreInfoTable implements java.io.Serializable {

	// Fields

	private ScoreInfoTableId id;
	private Double score;

	// Constructors

	/** default constructor */
	public ScoreInfoTable() {
	}

	/** full constructor */
	public ScoreInfoTable(ScoreInfoTableId id, Double score) {
		this.id = id;
		this.score = score;
	}

	// Property accessors

	public ScoreInfoTableId getId() {
		return this.id;
	}

	public void setId(ScoreInfoTableId id) {
		this.id = id;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}