package com.kjcourse.service;

import java.util.ArrayList;

import com.kjcourse.model.Course;
import com.kjcourse.model.CourseGrade;
import com.kjcourse.model.Student;

/**
 * The CourseManagement class provides static methods for managing courses,
 * student enrollments, grade assignments, and overall grade calculations.
 * 
 * It acts as a centralized service layer for the Course Enrollment and Grade
 * Management System, handling interactions between courses and students.
 */
public class CourseManagement {

    /**
     * A static list to store all courses offered by the system.
     */
    private static ArrayList<Course> allCourses = new ArrayList<>();


    /**
     * Adds a new course to the course list.
     * 
     * @param code     The unique course code.
     * @param name     The name of the course.
     * @param capacity The maximum number of students allowed to enroll.
     */
    public static void addCourse(String code, String name, int capacity) {
        Course newCourse = new Course(code, name, capacity);
        allCourses.add(newCourse);
    }

    /**
     * Enrolls a given student in a specified course.
     * 
     * @param s The student to be enrolled.
     * @param c The course in which the student will be enrolled.
     */
    public static void enrollStudent(Student s, Course c) {
        s.enrollInCourse(c);
    }

    /**
     * Assigns a grade to a student for a given course.
     * 
     * @param s     The student who is receiving the grade.
     * @param c     The course in which the grade is assigned.
     * @param grade The grade value (e.g., 85.5).
     */
    public static void assignGrade(Student s, Course c, Float grade) {
        s.assignGrade(c, grade);
    }

    /**
     * Calculates and returns the overall average grade for a student.
     * Only courses with non-null grades are included in the calculation.
     * 
     * @param s The student whose average grade is being calculated.
     * @return The average grade as a float, or 0 if no grades are present.
     */
    public static float calculateOverallGrade(Student s) {
        float total = 0;
        int count = 0;

        for (CourseGrade cg : s.getEnrolledCourses()) {
            if (cg.getGrade() != null) {
                total += cg.getGrade();
                count++;
            }
        }

        if (count > 0) {
            return total / count;
        } else {
            return 0;
        }
    }

    // Method to access the course list:
	public static ArrayList<Course> getAllCourses() {
		return allCourses;
	}
}

