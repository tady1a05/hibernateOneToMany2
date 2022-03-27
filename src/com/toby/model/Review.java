package com.toby.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	public Review(String comment, Course course) {
		this.comment = comment;
		this.course = course;
	}
	
	public Review() {
	}
	
	public Review(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + ", course Title=" + course.getTitle() + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name="comment")
	public String comment;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	public Course course; 
}
