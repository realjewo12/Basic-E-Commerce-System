package com.kjcourse.util;

import java.util.ArrayList;
import com.kjcourse.model.Course;
import com.kjcourse.model.Student;
import com.kjcourse.service.CourseManagement;

/**
 * Utility class to validate and check for duplicate or null references.
 */
public class DataValidator {
	
	private static ArrayList<Student> allStudents = new ArrayList<>();

    // Check if course exists by course code
	public static Course findCourseByCode(String code) {
	    if (code == null) return null;  // Return null if code is null

	    for (Course c : CourseManagement.getAllCourses()) {
	        if (code.equalsIgnoreCase(c.getCourseCode())) {
	            return c;
	        }
	    }
	    return null;  // Return null if no course matches the code
	}


    // Check if student exists by student ID
    public static Student findStudentById(String id) {
        
		if (allStudents == null || id == null) return null;

        for (Student s : allStudents) {
            if (id.equalsIgnoreCase(s.getStudentId())) {
                return s;
            }
        }
        return null;
    }

    // Prevent adding a duplicate course
    public static boolean isCourseCodeExists(ArrayList<Course> courses, String code) {
        return findCourseByCode(code) != null;
    }

    // Prevent adding a duplicate student
    public static boolean isStudentIdExists(ArrayList<Student> students, String id) {
        return findStudentById(id) != null;
    }

    public static Student getOrCreateStudent(String studentId) {
    	
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }

        // Search for existing student
        for (Student s : allStudents) {
            if (studentId.equalsIgnoreCase(s.getStudentId())) {
                return s;  // Found existing student
            }
        }

        // Not found, create new Student with default name or empty string
        Student newStudent = new Student(studentId, "Unknown Name");
        allStudents.add(newStudent);
        return newStudent;
    }
}

