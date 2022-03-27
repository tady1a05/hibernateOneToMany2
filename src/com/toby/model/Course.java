package com.toby.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	public Course(String title) {
		this.title = title;
	}
	
	public Course(String title, Instructor instructor) {
		this.title = title;
		this.instructor = instructor;
	}
	
	public Course() {
		
	}
	
	public void add(Review review) {
		if(this.review == null) {
			this.review = new ArrayList<>();
		}
		
		this.review.add(review);
		review.setCourse(this);
	}
	
	@Override
	public String toString() {
		return "Course [ID=" + ID + ", title=" + title + ", instructor id =" + instructor.getID() + ", instructor name =" + instructor.getFirstName() + " " + instructor.getLastName() + ", review=" + review + "]";
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String ID;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="course")
	private List<Review> review;
		
	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
