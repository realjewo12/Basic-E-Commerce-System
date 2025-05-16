package com.kjcourse.model;

import java.util.ArrayList;

/**
 * Represents a student with a unique ID, name, and a list of enrolled courses along with their grades.
 * Provides functionality to enroll in courses, assign grades, and retrieve student information.
 * 
 * This class maintains an internal list of CourseGrade objects which track the courses
 * the student is enrolled in and their associated grades.
 */

public class Student {

	// Private instance variables
    private String studentId;
    private String name;
    private ArrayList<CourseGrade> enrolledCourses;  // List of course-grade pairs

    /**
     * Constructs a new Student with the specified ID and name.
     * Initializes the enrolled courses list as empty.
     * 
     * @param id the unique student ID
     * @param name the full name of the student
     */
     public Student(String id, String name) {
        this.studentId = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }
     
     /**
      * Enrolls the student in the specified course if not already enrolled and
      * if the course has capacity.
      * 
      * If enrollment is successful, the course's current enrollment count is incremented.
      * Prints messages indicating success or failure.
      * 
      * @param c the course to enroll in
      */ 
     public void enrollInCourse(Course c) {
         if (! alreadyEnrolled(c)) {
        	 if (c.getCurrentEnrollment() < c.getMaxCapacity()) {
        		 enrolledCourses.add(new CourseGrade(c));
                 c.incrementCurrentEnrollment(); 
                 System.out.println("Student successfully enrolled in the course");
        	 } else {
        		 System.out.println("Course full");
        	 }
         } else {
        	 System.out.println("Already enrolled in this course");		
         } 
     }
     
     /**
      * Assigns a grade to the student for the specified course.
      * If the student is not enrolled in the course, an appropriate message is printed.
      * 
      * @param c the course for which the grade is assigned
      * @param grade the grade value to assign
      */
     public void assignGrade(Course c, float grade) {
    	 
         for (CourseGrade cg : enrolledCourses) {
        	 if (cg.getCourse().equals(c)) {
        		 cg.setGrade(grade);
        		 System.out.println("Grade successfully assigned");
        		 return;
        	 }
         }
 
         System.out.println("Cannot assign grade: Not enrolled in this course");
     }
     
     /**
      * Checks whether the student is already enrolled in the specified course.
      * 
      * @param c the course to check enrollment for
      * @return true if the student is enrolled, false otherwise
      */
     private boolean alreadyEnrolled(Course c) {
         for (CourseGrade cg : enrolledCourses) {
        	 if (cg.getCourse().equals(c)) {
        		 return true;
        	 }
         }
         return false;
     }
     
     // Getters and setters for name and ID
     public String getStudentId() {
         return studentId;
     }

     public String getName() {
    	 return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setStudentId(String id) {
         this.studentId = id;
     }

     // Method to get grades or enrolled courses
     public ArrayList<CourseGrade> getEnrolledCourses() {
         return enrolledCourses;
     }
	
}
