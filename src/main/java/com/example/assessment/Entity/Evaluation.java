package com.example.assessment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String studentName;
	private String course;

	private Integer mark1;
	private Integer mark2;
	private Integer mark3;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getMark1() {
		return mark1;
	}

	public void setMark1(Integer mark1) {
		this.mark1 = mark1;
	}

	public Integer getMark2() {
		return mark2;
	}

	public void setMark2(Integer mark2) {
		this.mark2 = mark2;
	}

	public Integer getMark3() {
		return mark3;
	}

	public void setMark3(Integer mark3) {
		this.mark3 = mark3;
	}
}
