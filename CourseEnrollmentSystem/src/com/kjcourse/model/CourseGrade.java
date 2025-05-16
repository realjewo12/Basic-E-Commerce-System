package com.kjcourse.model;

/**
 * Represents a pairing of a @link Course with an optional grade for a student.
 * This class is used in the context of a student's record to track their enrollment 
 * in a course and the grade (if assigned).
 * 
 * A grade may be null initially, indicating that it hasn't yet been assigned.
 */

public class CourseGrade {

	private Course course;
	private Float grade;  // Can be null if not yet assigned

	// Constructor for course with no grade initially
	public CourseGrade(Course course) {
        this.course = course;
        this.grade = null;
    }
	
	// Constructor with initial grade
	public CourseGrade(Course course, Float grade) {
        this.course = course;
        this.grade = grade;
    }
	
	// Getter for the course
    public Course getCourse() {
        return course;
    }

    // Getter for the grade
    public Float getGrade() {
        return grade;
    }

    // Setter for the grade
    public void setGrade(Float grade) {
        this.grade = grade;
    }
}
