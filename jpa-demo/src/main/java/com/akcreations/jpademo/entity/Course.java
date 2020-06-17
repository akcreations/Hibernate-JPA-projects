package com.akcreations.jpademo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private Integer courseId;
	
	private String courseName;
	
	@CreationTimestamp
	private LocalDateTime creation_date;
	
	@UpdateTimestamp
	private LocalDateTime last_updated_date;
	
	//course is the variable name in review class
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();	
	
	@ManyToMany
	@JoinTable(name="COURSE_STUDENT",
	joinColumns = @JoinColumn(name="COURSE_ID"),
	inverseJoinColumns = @JoinColumn(name="STUDENT_ID"))
	private List<Student> students = new ArrayList<>();
	
	protected Course()
	{
		
	}
	

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
     
	public Course(int courseId,String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}
	

	public List<Student> getStudents() {
		return students;
	}


	public void addStudent(Student student) {
		this.students.add(student);
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	@Override
	public String toString() {
		return "\nCourse [courseId=" + courseId + ", courseName=" + courseName + "]";
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}

	
}
